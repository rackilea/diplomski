ArrayList<File> files = new ArrayList<>();// put your files here
        File output = new File("yourfilename");
        BufferedOutputStream boss = null;
        try 
        {
            boss = new BufferedOutputStream(new FileOutputStream(output));
            for (File file : files) 
            {
                BufferedInputStream bis = null;
                try
                {
                    bis = new BufferedInputStream(new FileInputStream(file));
                    boolean done = false;
                    while (!done)
                    {
                        int data = bis.read();
                        boss.write(data);
                        done = data < 0;
                    }
                }
                catch (Exception e)
                {
                    //do error handling stuff, log it maybe? 
                }
                finally
                {
                    try
                    {
                        bis.close();//do this in a try catch just in case
                    }
                    catch (Exception e)
                    {
                        //handle this
                    }
                }               
            }
        } catch (Exception e) 
        {
            //handle this
        }
        finally
        {
            try 
            {
                boss.close();
            } 
            catch (Exception e) {
                //handle this
            }
        }