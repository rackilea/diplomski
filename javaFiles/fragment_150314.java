public static class Product {

    protected String department;
    protected String unit;
    protected int quantity;
    protected double price;
    protected long code;
    protected String name;

    private static NumberFormat formatter = new DecimalFormat("#0.00");

    public Product(String dep,String uom,int qnt,double prz,long cod,String nm) {

    setDep(dep);
    setUom(uom);
    setQnt(qnt);
    setPrz(prz);
    setCod(cod);
    setNm(nm);
    }

    public void setPrz(double prz){
       this.price = price;
    }

    //Other setters

    public double getPrz(){
       return price;
    }

    //Other getters
    @Override
    public String toString() {
        return  String.format(department+";"+unity+";"+quantity+";"+formatter.format(price)+";"+code+";"+name);
    } 

}