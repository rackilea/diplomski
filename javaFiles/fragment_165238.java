double sum = 0;
for (int i=1; i<TARGET; i++) {
   double element = Math.pow(-1,i+1) / (2*i + 1); //element i
   sum += element; // add element i to the results so far
}
double result = 4*sum;