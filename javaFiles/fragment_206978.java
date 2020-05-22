import java.util.ArrayList;

class Smartphone{
    public String serialNo;
    public String brand;
    public Double price;

    public Smartphone(String serialNo, String brand){
        this.serialNo = serialNo;
        this.brand = brand;
    }

    public void setPrice(double price){
        this.price = price;
    }

}

public class Test{
    public static void main(String[] args) throws Exception{
        ArrayList<Smartphone> smartphones = new ArrayList<Smartphone>();

        for (int i = 0; i < 5; i++){
            Smartphone s = new Smartphone("12345678" ,"Samsung");
            smartphones.add(s);
        }


        //later I realize I want to add the price, 
        //but it seems the loop I'm using is not working
        for (int i = 0; i < 5; i++){
            smartphones.get(i).setPrice(398);
        }

        // Display prices to ensure they were set
        for (Smartphone phone : smartphones) {
            System.out.println(phone.price);

        }

    }
}