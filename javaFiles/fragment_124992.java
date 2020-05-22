int seconds = (time & 31) * 2;
int minutes = (time >> 5) & 63;
int hours   = (time >> 11) & 31;
int day   = date & 31;
int month = (date >> 5) & 15;
int year  = ((data >> 9) & 127) + 1980;