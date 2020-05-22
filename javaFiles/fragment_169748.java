float sphereDiam;
double sphereRadius;
double sphereVolume;

System.out.println("Enter the diamater of a sphere:");
sphereDiam = keyboard.nextFloat();
sphereRadius = (sphereDiam / 2.0);
sphereVolume = ( 4.0 / 3.0 ) * Math.PI * Math.pow( sphereRadius, 3 );
System.out.println("The volume is: " + sphereVolume);