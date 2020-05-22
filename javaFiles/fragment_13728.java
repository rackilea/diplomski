FileItemIterator iter = upload.getItemIterator(request);
while (iter.hasNext()) {
    FileItemStream item = iter.next();
    InputStream stream = item.openStream();

    // the order of items is given by client, first form-fields, last file stream
    if (item.isFormField()) {
        String name = item.getFieldName();
        String value = Streams.asString(stream);
        // here we get the param1 and param2
    } else {
        String filename = item.getName();
        String mimetype = item.getContentType();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int nRead;
        while ((nRead = stream.read(buffer, 0, buffer.length)) != -1) {
            System.out.println("lenth111" +nRead);
            output.write(buffer, 0, nRead);
        }
        System.out.println("lenth" +nRead);
        output.flush(); 
    }
}