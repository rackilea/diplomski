public class PP43CarTest {

    public static void main(String[] args) {

        //Declaring objects
        PP43Car car1;
        PP43Car car2;
        PP43Car car3;

        //Instantiating objects
        car1 = new PP43Car("Millenia", "Mazda", 2011);
        car2 = new PP43Car("Aaaa", "Bbb", 2012);
        car3 = new PP43Car("Ccc", "Ddd", 2012);

        //Updating objects
        car1.setMake("Xxx");
        car1.setMake("Yyy");
        car1.setYear(2013);

        //Printing objects
        System.out.println("CAR 1: " + car1.toString());
        System.out.println("CAR 2: " + car2.toString());
        System.out.println("CAR 3: " + car3.toString());
    }
}