public class Sign {

// These are no longer final as you need to change them
private static String TXT_PLACE_NAME;
private static String TXT_VERBING;
private static String TXT_NOUN;
protected static String SIGNS;


// Since they're not final reset can change them.
public void reset(){
    TXT_PLACE_NAME      = buildingText();
    TXT_VERBING         = verbText();
    TXT_NOUN            = nounText();
    SIGNS = "Welcome to the  "+ "\n \n "+ TXT_PLACE_NAME+ " of the "+ TXT_VERBING + TXT_NOUN + "";
}

// This ensures that they get initialized initially
static {
    reset();
}

// ...

}