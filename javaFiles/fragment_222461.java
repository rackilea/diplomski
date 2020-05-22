public Stock(Stock other) throws IllegalArgumentException
{
    this(other.ticker, other.shares, other.purchasePrice);
    this.latestPrice = other.latestPrice;
    updatePercentGain();
}