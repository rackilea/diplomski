OutputStreamWriter osw = null;
        try
        {
            osw = new OutputStreamWriter(new FileOutputStream("textfile.txt"), "ISO-8859-1");
            osw.write("Here comes some output");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            if(osw != null) {
                try
                {
                    osw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }