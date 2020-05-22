import org.junit.Test;
import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.italianStemmer;

public class SnowballItalianStemmerTest {

    @Test
    public void testSnowballItalianStemmerAttaccare() {

        SnowballStemmer stemmer = (SnowballStemmer) new italianStemmer();

        String[] tokens = "attacco attacchi attacca attacchiamo attaccate attaccano".split(" ");    
        for (String string : tokens) {
            stemmer.setCurrent(string);
            stemmer.stem();
            String stemmed = stemmer.getCurrent();
            Assert.assertEquals("attacc", stemmed);
            System.out.println(stemmed);
        }

    }

}