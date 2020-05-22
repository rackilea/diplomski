public final static <T extends Enum<T> & Rank> Comparator<Card<T>> 
    comparatorByAttribute1() {
    return new Comparator<Card<T>>() {

        @Override
        public int compare(Card<T> o1, Card<T> o2) {
            return 0;
        }
    };
}