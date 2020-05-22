public class temp {

    static String cars = "";

    public static void appendToCars(String something)
    {

        if (cars.equals("")){
            cars = something;
        }
        else {
            cars= cars + "," + something;
        }

    }

    public static void main(String[] args){

        String newcar1 = "Mini";
        String newcar2 = "LandRover";

        appendToCars(newcar1);
        appendToCars(newcar2);
        System.out.println(cars);
    }
}