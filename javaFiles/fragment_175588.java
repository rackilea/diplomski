int hr = seconds/3600;
  int rem = seconds%3600;
  int mn = rem/60;
  int sec = rem%60;
  String hrStr = (hr<10 ? "0" : "")+hr;
  String mnStr = (mn<10 ? "0" : "")+mn;
  String secStr = (sec<10 ? "0" : "")+sec;