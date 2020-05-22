public static void main(String[] args)  {
    Garage g = new Garage();
    Vehicle c = new Car();
    Vehicle b = new Bike(); //assuming Bike is a subclass of Vehicle.
    g.repair(c);
    g.repair(b);
}