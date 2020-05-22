long oneYear = 60 * 24 * 365;
long oneDay = 60 * 24;
long oneHour = 60;

// extract years
int years = time / oneYear;
// update your time
time = time % oneYear;

// extract days
long days = time / oneDay;
// update your time
time = time % oneDay;

// extract hours    
long hours = time / oneHour;

// extract minutes (the remaining)
minutes = time % oneHour;