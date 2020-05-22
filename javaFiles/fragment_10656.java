class Car{
    private String owner;
    private String reg;
    private String make;
    private int kilometres;
    private double price;
    public Car(String owner, String reg, String make, int kilometres, double price){
            this.owner = owner; this.reg = reg;this.make = make; 
            this.kilometres = kilometres; this.price = price; 
    }
    public String getOwner(){return owner;}
    public String getReg(){return reg;}
    public String getMake(){return make;}
    public getKilometres(){return kilometres;}
    public double getPrice(){return price;}
}