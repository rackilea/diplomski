private Task create(String option) {
  if (option.toLowerCase().compareTo("mean") == 0) {
    return new MeanTask();
  }
  else if ....
}