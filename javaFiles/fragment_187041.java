public enum Rank {ACE(1), TWO(2); /* obviously add the other values*/
    private int value  ;
    Rank(int value){
        this.value = value;
    };
    public int getValue(){
       return this.value;
    }

    public int calcDifference(Rank rank){
        return getValue() - rank.getValue();
    }

};