public static void initProperties(String fileName) {    

   Properties testProperties = new Properties();    

   File file = new File(fileName);
   FileInputStream stream = null;   
   try {    
      stream = new FileInputStream(file);   
      testProperties.load(stream);  
   } catch (IOException e) {    
      // Log or whatever you want to do
   } finally {  
      if (stream != null) {
      try { 
         stream.close();    
   } catch (IOException e) {    
     // Log or whatever you want to do; 
   }    

   MyConfiguration config = ConfigFactory.create(MyConfiguration.class, testProperties);    
   PropertiesAccessor.setProperties(config);
}