public class ReadPropertiesFile {


public static void readProp() {

 try {
    Properties prop = new Properties();
    prop.load(ReadPropertiesFile.class.getResourceAsStream("/application.properties"));

    Enumeration enuKeys = prop.keys();
        while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = prop.getProperty(key);
                if (key.startsWith("prefix") || key.startsWith("some")) {
                    System.out.println(key + "= " + value);
                }
            }
            } catch (FileNotFoundException e) {
            //System.out.print("System cannot find file");
                e.printStackTrace();
            } catch (IOException e) {
                //System.out.print("System cannot find file");
                e.printStackTrace();
            }
}