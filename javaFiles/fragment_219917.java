public class StringArray {
    private static final String[] stringArray;

    static {
        String[] temp = new String[5];
        temp[0] = "AAA";        
        temp[1] = "AAB";        
        temp[2] = "AAA";        
        temp[3] = "AAC";        
        temp[4] = "AAA";    
        stringArray = temp;    
    } 
}

public class LongString {
    private static final String longString;

    static {
        longString = "AAAAABAAAAACAAA";
    } 
}