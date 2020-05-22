abstract class Parser {
    public abstract void parse( ... );
    protected String readLine() { ... }
}

class SpecialPurposeParser extends Parser {
    public void parse( ... ) { 
        // ... special stuff
        readLine();
        // ... more stuff
    }
}