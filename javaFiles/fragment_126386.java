private static final String FILE_HEADER_BLOCK = 
        "application/vnd.xfdl;content-encoding=\"base64-gzip\"";  

    public static Document OpenXFDL(String inputFile) 
            throws IOException, 
                ParserConfigurationException,
                SAXException

    {
        try{

            //create file object
            File f = new File(inputFile);
            if(!f.exists()) {
                throw new IOException("Specified File could not be found!");
            }

            //open file stream from file
            FileInputStream fis = new FileInputStream(inputFile);

            //Skip past the MIME header
            fis.skip(FILE_HEADER_BLOCK.length());   

            //Decompress from base 64                   
            Base64.InputStream bis = new Base64.InputStream(fis, 
                    Base64.DECODE);

            //UnZIP the resulting stream
            GZIPInputStream gis = new GZIPInputStream(bis);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(gis);

            gis.close();
            bis.close();
            fis.close();

            return doc;
        }
        catch (ParserConfigurationException pce) {
            throw new ParserConfigurationException("Error parsing XFDL from file.");
        }
        catch (SAXException saxe) {
            throw new SAXException("Error parsing XFDL into XML Document.");
        }
    }