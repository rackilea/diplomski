...
double x = 1.0;
double y = 20.0;
double k;
double m;

System.out.print("Feet\tMeters\t|   Meters\tFeet"); 
for (int i=0; i<10; i++) {
  k = footToMeter(x);
  m = meterToFoot(y);

  System.out.printf("\n%.1f\t%.3f\t|   %.1f\t%.3f",x,k,y,m);
  x = x+1;
  y = y+5;
 }
}

public static double footToMeter(double foot) {
 return 0.305 * foot;
}

public static double meterToFoot(double meter) {
 return 3.279 * meter;
}