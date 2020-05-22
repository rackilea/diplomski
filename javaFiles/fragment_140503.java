public class PropertiesLoader{

       public Map<String,Integer> loadCities(){
             Properties file=getProperties("configuration.properties");
             return convertPropertiesToMap(file); //it will be return empty Map if       unable to load properties

       }

       private Properties getProperties(String fileName){
              Properties prop = new Properties();
              InputStream input = null;

              try {
                   input = getClass().getClassLoader().getResourceAsStream(fileName);
                   if (input == null) {
                    //Unable to find file
                                return null;
                   }
                   prop.load(input);

              } catch (IOException ex) {
                           ex.printStackTrace();
              } finally {
                           if (input != null) {
                                  try {
                                        input.close();
                                  } catch (IOException e) {
                                        e.printStackTrace();
                                  }
                           }
          }
             return prop;
       }

       private Map<String,Integer> convertPropertiesToMap(Properties file){
              Map<String,Integer> result=new HashMap<String,Integer>();
                        if(file != null){
                               Enumeration<?> e = file.propertyNames();
                               while (e.hasMoreElements()) {
                                      String key = (String) e.nextElement();
                                      Integer value = Integer.parseInt(file.getProperty(key));
                                      result.put(key,value);
                               }
                    }     
              return result;
       }


}