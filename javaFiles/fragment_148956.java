public class BadHash {

    private String aString;

    public BadHash(String s) {
        aString = s;
    }

    public int hashCode() { 
        return aString.length();
    }

    public boolean equals(Object other) {
        // boilerplate stuff
        BadHash obj = (BadHash) other;
        return obj.aString.equals(aString);
    }
}