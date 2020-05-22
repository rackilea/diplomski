public class Main
{
    public static void main()
    {
        Car car1 = new Car();
        car1.setModel ( "Toyota" );
        car1.setPrice ( 1500 );

        Car car2 = new Car();
        car2.setModel ( "Peugeot" );
        car2.setPrice ( 2600 );

        int biggestPrice = Math.max ( car1.getPrice(), car2.getPrice() ) 

        String model = "";

        switch ( biggestPrice ) {
            case car1.getprice: 
                model = car1.getModel();
                break;
            case car2.getPrice: 
                model = car2.getModel();
                break;
            default: 
                assert false : "Got a number that should not be able to appear";
                System.out.println ( "ERROR!" );
                return;
        }

        System.out.println("The most expensive car is " + model); 
    }

    class Car
    {
        String model;
        int price;

        public Car () {}

        public Car ( String model, int price ) 
        {
            this.model = model;
            this.price = price; 
        }

        public void getModel ( )
        {
            return this.model;
        }

        public void setModel (String model )
        {
            this.model = model;
        }

        public void getPrice ( )
        {
            return this.price;
        }

        public void setPrice ( int price )
        {
            this.price = price;
        }
    }

}