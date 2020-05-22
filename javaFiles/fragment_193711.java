double lat = 53.186288;
double longitude = -8.043709;
double lat1 = lat - 4;
double longitude1 = longitude - 8;
double lat2 = lat + 4;
double longitude2 = longitude + 8;

double[][] bb = {{longitude1, lat1}, {longitude2, lat2}};

FilterQuery fq = new FilterQuery();
fq.locations(bb);
twitterStream.filter(fq);