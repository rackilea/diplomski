public static final Comparator<ValueWords> valComparator = new Comparator<ValueWords>() {
    @Override
    public int compare(ValueWords v1, ValueWords v2) {
        if(v1.valWord == v2.valWord)
            return v1.phraseWord - v2.phraseWord;
        else 
            return v1.valWord - v2.valWord;
    }
};