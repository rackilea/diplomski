function dateFromJulianDay(julian_day) {
  return new Date( (julian_day - 2440587.5) * 86400000);
}

function dateToJulianDay(date) {
  // date should be a javascript Date object
  // or a variable with milliseconds since the unix epoch 1 jan 1970
  return ( date / 86400000) + 2440587.5;
}

console.log(dateFromJulianDay(2455449));

console.log(dateToJulianDay(new Date(2010,9-1,9)));