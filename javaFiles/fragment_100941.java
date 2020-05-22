public byte[] searchForContent(Part part,String fileName){
    if(part.getFileName()!=null){
        if(part.getFileName().equals(fileName)){
            InputStream stream=part.getInputStream();

            byte[] buffer = new byte[512];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int bytesRead;
            while ((bytesRead = stream.read(buffer) != -1)
            {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
    return null;
}