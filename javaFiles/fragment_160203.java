double takttime = 1.08;

int t = (int) ( 100 * takttime * 60 );

int hour = t/3600;
t %= 3600;
int min = t/60;
t %= 60;
int sec = t;