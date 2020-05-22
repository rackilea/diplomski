if (year <= 0) {
  fields[ERA] = BC;
  fields[YEAR] = 1 - year;
} else {
  fields[ERA] = AD;
  fields[YEAR] = year;
}