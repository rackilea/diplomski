class book implements Serializable 
{
    String name;
    String author;
    int nop;
    int price;
    int discount;

    void getDiscount()
    {
        int finalprice=price-((price/discount));
        System.out.println("Final price after discount="+finalprice);
    }

    public String toString() {
    return name + author +nop + price +discount;
    // above can be any format whatever way you want


    }
}