package tst;

public class CarTest {

    public static void main(String[] args) {
        // creating new instance of the Car and at once setting all its fields in constructor
        // now as I see the assignment, this line corresponds to 
        // CarV5 car1 = new CarV5(carType1, endMiles1, startMiles1, gallonsUsed1, pricePerGallon1);
        Car car = new Car(43266, 43422, 7.8);

        //calculating and printing the result w/o providing values but using instance fields
        System.out.println(car.calcDistance());

    }




    // the Car class itself, you can put it in different file
    public static class Car {

        // note that fields are NOT static, i.e. they belong to an INSTANCE of the class, not the class itself
        private int sMiles1;
        private int eMiles1;
        private double gals1;

        //
        public Car(int sMiles1, int eMiles1, double gals1) {
            this.sMiles1 = sMiles1;
            this.eMiles1 = eMiles1;
            this.gals1 = gals1;
        }

        // example of your methods
        public int calcDistance(){
            return this.eMiles1 - this.sMiles1;
        }

        // other methods you need

    }

}