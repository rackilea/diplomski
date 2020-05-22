private StreamResource createZipResource()
{ 
    return new StreamResource(new StreamSource()
    { 
        @Override
        public InputStream getStream()
        {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            try
            {
                ZipOutputStream out = new ZipOutputStream(byteArrayOutputStream);

                for (int i = 0; i < listData.size(); i++)
                {
                    if (listData.get(i).contains(".txt"))
                    { 
                        out.putNextEntry(new ZipEntry(listData.get(i) + ".txt"));
                    }
                    else
                    {
                        out.write(listData.get(i).getBytes());                            
                    } 
                }
                out.close();
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray()); 
            } 
            catch (IOException e)
            {
                System.out.println("Problem writing ZIP file: " + e);
            }
            return null; 
        }
    },"Filename.zip"); 
}