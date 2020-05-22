import java.util.ArrayList;
import java.util.Arrays;

public class FactBook {
    // Public data members are not recommended.
    // Make it at least protected and arrange controlled access to it
    // by specific methods
    public ArrayList<String> mFacts = 
       new ArrayList<String>(
                Arrays.asList("Quote 1.", "Quote 2.")
       )
    };

    public String getFact() {

        String fact = "";
        // Do you need to create a new Random every time?
        // Perhaps creating it only once and storing it in a static
        // (class wide) data member will be just as good: create it once,
        // reuse it later.
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mFacts.size());
        fact = mFacts.get(randomNumber);

        return fact;

    }

    // how to add
    public void add(String newQuip) {
        // Don't accept null or "all-white character" quotes
        if(null!=newQuip && newQuip.trim().length()>0) {
            this.mFacts.add(newQuip);
        }
    }
}