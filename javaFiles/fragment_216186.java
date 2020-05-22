InputStream ins = new BufferedInputStream(socket.getInputStream());
    while (!finished) {
      ByteArrayOutputStream buf = new ByteArrayOutputStream();
      int b;
      while ((b = ins.read()) > 0) {
        buf.write(b);
      }
      if (b == -1)
        throw new EOFException("EOF while reading from socket");
      // b == 0
      Document xml = readXML(new ByteArrayInputStream(buf.toByteArray()));
      processAnswers(xml);
      Element root = xml.getDocumentElement();
      if (root.hasAttribute("fragmentLength")) {
        int length = DatatypeConverter.parseInt(
                root.getAttribute("fragmentLength"));
        boolean last = DatatypeConverter.parseBoolean(
                root.getAttribute("isLastFragment"));
        int read = 0;
        while (read < length) {
          // split incoming fragment into 4Kb blocks so we don't run 
          // out of memory if the client sent a really large fragment
          int l = Math.min(length - read, 4096);
          byte[] fragment = new byte[l];
          int pos = 0;
          while (pos < l) {
            int c = ins.read(fragment, pos, l - pos);
            if (c == -1)
              throw new EOFException(
                      "Preliminary EOF while reading fragment");
            pos += c;
            read += c;
          }
          // process fragment
        }