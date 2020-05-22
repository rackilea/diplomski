public static void main(String[] args) {
    Bicycle bike = new Bicycle();
    Scanner sc = new Scanner(System.in);

    System.out.println("Give the gear :");
    bike.setGear(Integer.parseInt(sc.nextLine()));

    System.out.println("Give the cadence :");
    bike.setCadence(Integer.parseInt(sc.nextLine()));

    double speed = bike.getSpeed();
    System.out.println(speed);
}