public class Product {

    String desription;

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }
}


//this is your hidding delegation getter only in main class (Sample in my samples)
public String getDescription(){
    return _product.getDesription();
}