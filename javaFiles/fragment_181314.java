double[] max = {0,9075,36900,89350,186350,405100};
double[] rate = {0,0.10,0.15,0.25,0.28,0.33};
double left = income;
double tax = 0.0d;
for(int i = 1; i < max.length && left > 0; i++) {
    double df = Math.min(max[i]-max[i-1],left);
    tax += rate[i]*df;
    left -= df;
}