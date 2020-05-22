// assume that time is expressed using some class
Time[] time = ...
// assume that the water speed is double, expressed in volume per unit of time.
// Further assume that Time units match the units in the denominator of water speed,
// e.g. if the speed is in galons per minute, then the time unit is minutes;
// if the speed is in galons per second, then the time unit is seconds, and so on
double[] speed = ...

double sum = 0;
for (int i = 0 ; i < time.length-1 ; i++) {
    double deltaT = time[i+1].subtract(time[i]).toTimeUnits();
    // This is the formula for the trapezoidal rule on non-uniform grid
    sum += (speed[i]+speed[i+1])*deltaT;
}
double totalFlow = sum / 2;