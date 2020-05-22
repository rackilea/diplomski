@parser::members { 
   ...
    private YourErrorTrackerInterface errorTracker;

    //getter/setter for errorTracker here        

    @Override    
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        if (errorTracker != null){
          errorTracker.addError(e, tokenNames, hdr, msg);
        }
    }
    ...
}
//same code in @lexer::members