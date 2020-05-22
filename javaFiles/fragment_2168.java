public abstract class Price {
    protected static final int _priceCode;    // do you really need static?

    Price(int p){ this._priceCode=p;}
    public abstract double getAmount(int rentalDays);
    public int getPriceCode(){ return _priceCode; }

}