isLeapYear = (year % 4 == 0);
// isLeapYear = true

isLeapYear = isLeapYear && (year % 100 != 0);
// year % 100 IS 0. so the second part evaluates to false giving
// true && false which yields isLeapYear as false

isLeapYear = isLeapYear || (year % 400 == 0);
// this is just false || false
// which evaluates to false