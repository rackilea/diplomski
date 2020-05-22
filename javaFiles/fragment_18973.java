private String original;
    private String reversed;

    public ReverserResult( String reverseMe ) {
        this.original = reverseMe;
        this.reversed = reverseString( reverseMe );
    }