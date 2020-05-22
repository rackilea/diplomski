import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import com.google.api.GoogleAPI;

public class JTranslator {
  public static void main(String[] args) throws Exception {
    // Set the HTTP referrer to your website address.
    GoogleAPI.setHttpReferrer("http://duckduckgo.com");

    // Set the Google Translate API key
    // See: http://code.google.com/apis/language/translate/v2/getting_started.html
    GoogleAPI.setKey("hSifeHtllArOfSknahTgNoLo-SyXaLago-TeDIuGsReki-HhctIH");

    String translatedText = Translate.DEFAULT.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH);

    System.out.println(translatedText);
  }
}