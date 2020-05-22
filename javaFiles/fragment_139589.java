class SingleProcessReadingDecorator extends Parser {
    private Parser parser;
    private String processId;
    public SingleProcessReadingDecorator( Parser parser, String processId ) {
        this.parser = parser;
        this.processId = processId;
    }

    public void parse( ... ) { parser.parse( ... ); }

    public String readLine() {
        String text = super.readLine();
        if( /*text is for processId */ ) { 
            return text; 
        }
        else {
            //keep readLine'ing until you find the next line and then return it
            return this.readLine();
        }
    }