import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Abbreviation {
    ABBR1("long text 1", "another description 1", "yet another one 1"), 
    ABBR2("long text 2", "another description 2", "yet another one 2"); 

    private static final Map<String, Abbreviation> ABBREVIATIONS = new HashMap<>();

    private String[] longForms;
    private Abbreviation(String... longForms) {
        this.longForms = longForms;
    }

    public String toString () {
        return Arrays.toString(longForms);
    }

    static {
        for(Abbreviation abbr : values()) {
            for(String longForm : abbr.longForms) {
                ABBREVIATIONS.put(longForm, abbr);
            }

        }
    }

    public static Abbreviation of(String longForm) {
        Abbreviation abbreviation = ABBREVIATIONS.get(longForm);
        if(abbreviation == null) throw new IllegalArgumentException(longForm + " cannot be abbreviated");
        return abbreviation;
    }



    public static void main(String[] args) {
        Abbreviation a =  Abbreviation.of("yet another one 2");
        System.out.println(a == Abbreviation.ABBR2); //true
    }
}