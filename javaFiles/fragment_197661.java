import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class StringToProp {

    public static void main(String[] args) {
        String str1 = "property: IS_IN_AGO, type: String, description: hej, helpValuesMethod: null, value: 1-SSCFAP1301498_KB$2(SSCBFM901290), inputPattern: , height:";
        String str2 = "property: AGO_MATERIAL, type: String, description: SSC Material, helpValuesMethod: null, value: 1400421-0010, inputPattern: , height: 4";
        String str3 = "property: AGO_SEPARATOR, type: String, description: SSC Separator, helpValuesMethod: null, value: :, inputPattern: , height: 4";

        printProperty(str1);
        printProperty(str2);
        printProperty(str3);
    }

    private static void printProperty(String str) {
        String propertiesFormat = str.replaceAll(",", "\n");
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(propertiesFormat));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("property") + " : " + properties.getProperty("value"));
    }

}