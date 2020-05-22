public class xmlValue {
    public static void main(String[] args) {
        String xml = "<ns2:aResponse xmlns:ns2=\"http://www.***.com/F1/F2/F3/2011-09-11\">\n" +
                "   <createBEntityResponse bEntityID=\"328\" />\n" +
                "</ns2:aResponse>";
        System.out.println(getTagValue(xml,"createBEntityResponse bEntityID"));
    }
    public static  String  getTagValue(String xml, String tagName){
         String [] s;
         s = xml.split("createBEntityResponse bEntityID");
         String [] valuesBetweenQuotes = s[1].split("\"");
         return  valuesBetweenQuotes[1];
    }
    }