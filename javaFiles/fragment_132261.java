FileWriter fw=null;
 try {
    fw= new FileWriter(configFile);
    IOUtils.write("test",fw);
    }catch (Exception e) {
     e.printStackTrace();
   }finally
   {
    IOUtils.closeQuietly(fw);
   }