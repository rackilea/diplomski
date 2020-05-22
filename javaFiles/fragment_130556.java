public void setTimeInMillis(long time) {
  clear();
  this.time = time;
  isTimeSet = true;
  computeFields();
}