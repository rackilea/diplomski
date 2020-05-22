static final int ONE_DAY_MILLIS = 86400 * 1000;
//....
long deltaMillis = vexp.getTime() - dv.getTime();
if (deltaMillis < 7 * ONE_DAY_MILLIS) {
  // within last 7 days
}