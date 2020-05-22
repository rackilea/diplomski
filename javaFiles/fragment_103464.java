final class DataBaseQueries { 
    // this one is private
    private final static String JOIN_A_B = " join A, B ";
    public final static String SOME_SCENARIO       = "SELECT z WHERE x > y " + JOIN_A_B ;
    public final static String SOME_OTHER_SCENARIO = "SELECT z WHERE x <= y " + JOIN_A_B ;

}