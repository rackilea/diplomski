long diffms = date2l - date1l; //difference in ms
long ts = diffms / 1000; //total difference in seconds

long mo = ts / 60 / 60 / 24 / 30; //(1)
long d = (ts - mo * 30 * 24 * 60 * 60) / (60 * 60 * 24); //follows on because of (1)
long h = (ts - d * 24 * 60 * 60) / (60 * 60); //follows on because of (1)
long m = (ts - h * 60 * 60) / 60; //follows on because of (1)