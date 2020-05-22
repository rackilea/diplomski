public String getStatus() {

if (destination == null) {
System.out.println("This Vehicle is free");
}
else if (location == destination) {
System.out.println ("This Vehicle is free");
}
return id + " at " + location + " headed for " + destination;
}