import java.util.Locale;

public class ToLocaleTest {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("lt")); //setting Lithuanian as locale
        String str = "\u00cc";
    System.out.println("Before case conversion is "+str+
" and length is "+str.length());// Ì
        String lowerCaseStr = str.toLowerCase();
    System.out.println("Lower case is "+lowerCaseStr+
" and length is "+lowerCaseStr.length());// iı`
    }
}