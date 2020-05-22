int a = Integer.parseInt(args[0]);
int b = Integer.parseInt(args[1]);
double ran = Math.random();
double random;

if(a < b)
    random = (b-a)*ran + a;
else
    random = (a-b)*ran + b;