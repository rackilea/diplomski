public static void main(String[] args) {

        Bicycle firstBicycle = new Bicycle(100, "Bicycle1");
        Bicycle secondBicycle = new Bicycle(200, "Bicycle2");
        Bicycle fastestBike = Bicycle.seeWhosFastest(firstBicycle, 
secondBicycle);
        System.out.println(fastestBike);
}