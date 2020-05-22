int sum = 0, drops = 0;
double pi = 0, oldPi;
do {
     oldPi = pi;
     double x = Math.random(), y = Math.random();
     if (x * x + y * y <= 1)
         sum++;
     drops++;
     pi = 4.0 * sum / drops;
} while (pi != oldPi || pi < 3); // pi < 3 to avoid problems when the first
// drops are outside of the circle, pi == 0 would also work, BUT setting
// pi to a value different from 0 at the beginning can still fail with only pi != oldPi