import java.util.*; 
public class I18NSample { 
  public ResourceBundle messages;
  static public void main(String[] args) { 
    String language, country; 
    if (args.length != 2) { // default is English-language
      language = new String("en"); country = new String("US"); 
    } else { 
      language = new String(args[0]); country = new String(args[1]);
    } 
    Locale currentLocale = new Locale(language, country); 
    messages = 
      ResourceBundle.getBundle("MessagesBundle", currentLocale);   
    System.out.println(messages.getString("greetings"));
    System.out.println(messages.getString("inquiry")); 
    System.out.println(messages.getString("farewell")); 
  } 
}