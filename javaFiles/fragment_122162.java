class Strategies {
    private static final Comparator<Person> PERSON_NAME_LENGTH_COMPARATOR = new StrategyOne();

    private static final Comparator<Person> PERSON_NAME_LEXICAL_COMPARATOR = new StrategyTwo();

    public static Comparator<Person> personNameLengthComparator(){
         return  PERSON_NAME_LENGTH_COMPARATOR;
    }


    public static Comparator<Person> personNameLexicalComparator(){
         return  PERSON_NAME_LEXICAL_COMPARATOR;
    }
}