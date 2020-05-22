JDateTime jdt = new JDateTime(milliseconds);
JulianDateStamp jds = jdt.getJulianDate();
// or:
double jdn = jdt.getJulianDateDouble()
// or:
int jdn = jdt.getJulianDateNumber()