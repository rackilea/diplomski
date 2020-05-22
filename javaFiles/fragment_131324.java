private void metadataMetaEx (File jpegFile)
{

    Metadata metadata = null;
    String tagInfo = null;
    XmpDirectory xmpDirectory = null;
    Map<String, String> xmp = null; 

    // Get all the metadata of the file
    try {
        metadata = ImageMetadataReader.readMetadata(jpegFile);
    } catch (ImageProcessingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    // Read in the metadata of the xmp directory
    try
    {
        xmpDirectory = metadata.getDirectory(XmpDirectory.class);
    } catch (NullPointerException e)
    {
        e.printStackTrace();
    }

    // Look through the xmp metadata for keys containing the word "Subject" and if a match add the value to the variable tagInfo
    if (xmpDirectory != null)
    {
        xmp = xmpDirectory.getXmpProperties();
        Iterator tags = xmp.keySet().iterator();
        tagInfo = "Image Tags: ";           
        while (tags.hasNext())
        {
            String key=(String)tags.next();

            if (key.contains("Subject"))
            {
                String value=(String)xmp.get(key);
                tagInfo += value
                        += "; ";                    
            }

        }           
    } }