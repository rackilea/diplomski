// Find frequency to the nearest hz (+/- 10%)
// It's assumed that some other process is responsible for updating the "diode"
// variable.  "diode" must be declared volatile.
long duration = 1000;   // 1 second
final int interval = 100;    // sampling inteval = .1 second
int oldState = diode;
int count = 0;
final long startTime = System.currentTimeMillis();
final long endtime = startTime + duration;
while (System.currentTimeMillis() < endtime) {
  // count all transitions, both leading and trailing
  if (diode != oldState) {
    ++count;
    oldState = diode;
  }
  Thread.sleep(interval);
}
// find the actual duration
duration = System.currentTimeMillis() - startTime;
// Compute frequency. The 0.5 term is because we were counting both leading and
// trailing edges.
float frequency = 0.5 * count / (duration/1000);