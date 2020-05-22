public void startEngine() {
   dishargeBattery(50);
   System.out.println("Start Engine");
 }

 public void startRadio() {
   dischargeBattery(20);
 }

 private void dischargeBattery(int value) {
   battery.energy -= value; //battery should probably be a private field.
 }