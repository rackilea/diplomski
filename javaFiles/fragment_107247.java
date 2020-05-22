enum Company{
    EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
    private int value;

    private Company(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}