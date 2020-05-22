public InputStream GetStreamFromXmlFileOnSDCard()
        {
            File file = new File(Environment.getExternalStorageDirectory() +xml_path);
            InputStream istr = null;
            try
                {
                    istr = new FileInputStream(file);
                }
            catch (FileNotFoundException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            return istr;

        }