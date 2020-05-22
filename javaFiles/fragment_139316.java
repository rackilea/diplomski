double radius_sum = 0.0;
double square_radius_sum = 0.0;

void createAG(double a, double b, double c){
 double n = a + b + c + Math.sqrt(a*b + a*c + b*c + 4.0); 
 if ((minD * n) < 1){
     radius_sum += 2. / n; //Remember about symmetry? 
     square_radius_sum += 2. * (1. / n) * (1. / n); //Remember about symmetry? 
     createAG(a, b, n);
     createAG(a, c, n);
     createAG(b, c, n);
   }
}