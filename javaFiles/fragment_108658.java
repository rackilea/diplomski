try
             {
               InputStream inputStream = ...

                    }
              assert inputStream != null; // here
              inputStream.close();

             }  catch (IOException e) {
                 e.printStackTrace();
                 } 
               }