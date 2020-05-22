if (i < 4) {
   year[i] = release[i];  //index 5 cannot be called here and year lenght is 4
}
if (i > 4 && i < 7) {
   month[i] = release[i]; //index 5 is called here and month lenght is 2
}
if (i > 7 && i < 10) {
   date[i] = release[i];
}