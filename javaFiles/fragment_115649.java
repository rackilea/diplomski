System.out.println("Skipped " + total + "/" + s.getBytes().length + " bytes.");

  while ((len = bais2.read(bytes, 0, size)) != -1)
  {
    baos2.write(bytes, 0, len); // <- added write offset and length
    baos2.flush();

    total += len;
  }