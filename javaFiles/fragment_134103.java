public static void main(String[] args) {

        Bicycle firstBicycle = new Bicycle(100);
        Bicycle secondBicycle = new Bicycle(200);
        Bicycle fastestBike = Bicycle.seeWhosFastest(firstBicycle, 
secondBicycle);
        System.out.println(fastestBike);
}