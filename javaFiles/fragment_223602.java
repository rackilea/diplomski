public static double[] calcGravity(double[] radius, double[] mass){
   double[] grav = new double[radius.length]();
   for (int i =0; i<radius.length;i++) {
      grav[i] = (6.67E-17) * mass[i] / Math.pow(radius[i], 2);
   }
   return grav;
}