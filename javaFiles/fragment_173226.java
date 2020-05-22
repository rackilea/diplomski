public class Product {
    private String pdesc, pname;
    private int pprice, pstock;

    public Product() { }

    public Product(String pdesc, String pname, int pprice, int pstock) {
        this.pdesc = pdesc;
        this.pname = pname;
        this.pprice = pprice;
        this.pstock = pstock;
    }

    public String getPdesc() { return pdesc; }
    public String getPname() { return pname; }
    public int getPprice() { return pprice; }
    public int getPstock() { return pstock; }
}