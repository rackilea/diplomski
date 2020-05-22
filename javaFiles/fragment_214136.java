public double getPriceForProduct(String ID){
for(Boot b : catalogue){
    if(b.getID().equals(ID)){
        return b.getPrice();
    }
}
System.out.println("We don't have a boot with that ID in stock.");
System.out.println(ID +"\n\n");
return -1;