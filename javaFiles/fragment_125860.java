public class MyCode {

public static void main(String[] args) throws Exception {        
    String packagePath= "/mypackage/MyResource.xml";
    String myPath ="src/main/java"+packagePath;
    File f = new File(myPath);
    System.out.println(f.exists());        
    InputStream is = Class.class.getResourceAsStream(packagePath);                
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder(); 
    Document d = db.parse(is);
    System.out.println(d.getElementsByTagName("a").item(0).getTextContent());         
    }    
}