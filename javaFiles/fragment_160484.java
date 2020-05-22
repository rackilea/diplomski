class YourPredicate implements Predicate<TradeDetailed>(){

    private final int compareAgainst;

    public YourPredicate(int compareAgainst){
        this.compareAgainst = compareAgainst;
    }

    @Override
    public boolean test(@NonNull TradeDetailed td) throws Exception {
        return td.getTypeId() == compareAgainst;
    }

}