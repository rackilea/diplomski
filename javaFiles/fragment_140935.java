import java.text.BreakIterator;
import java.util.Locale;

public class StringSplit {
    public static void main(String args[]) throws Exception {
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        String source = "This is a sentence. This is another. Rawlings, G. stated foo and bar.";
        iterator.setText(source);
        int start = iterator.first();
        for ( int end = iterator.next(); 
              end != BreakIterator.DONE; 
              start = end, end = iterator.next()) {
            System.out.println(source.substring(start, end));
        }
    }
}