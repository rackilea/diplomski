public void InfoGet() {
String softwareName;
int devicesAmount;

Scanner sc= new Scanner(System.in);
System.out.println("Welcome to the Software License Calculator");
System.out.println("Please type in the name of the Software:");

softwareName = sc.nextLine();

System.out.println("");

System.out.println("Please type in the number of devices that have the software:");
devicesAmount=sc.nextInt();

devices = new Devices(softwareName); // So we initialize the object.
devices.Calculations(devicesAmount);

sc.close();
System.out.println(devices.toString()); // Here we just call the toString() method we build to print the values.
}