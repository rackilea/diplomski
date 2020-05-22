public class PropertiesFile{

 private Properties prop;

 public PropertiesFile(String fileName) throws Exception
{
  init(fileName);
}

 private void init(String fileName) throws Exception
{
  prop = new Properties();

  try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);)
  {
     if(input == null)
     {
        throw new Exception("Enable to load properties file " + fileName);
     }

     prop.load(input);
  }
  catch(IOException e)
  {
     throw new Exception("Error loading properties file " + fileName);
  }
}

 public List<String> getPropertiesKeysList()
{
  List<String> result = new ArrayList<>();
  Enumeration<?> e = prop.propertyNames();
  while(e.hasMoreElements())
  {
     result.add((String) e.nextElement());
     // String value = prop.getProperty(key);
  }
  return result;
}
}