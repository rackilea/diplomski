int i = 0; 
double y = 0.9;
double x = 1.0;
double z = 0.1;

for (int o = 0; o < 1000; o++) {
    Double random = Math.random();
    Double mrnd = Math.floor(random*100)/100;

    double poa = (x*y);
    System.out.println("randomkalk " + mrnd);
    System.out.println("probability" + poa);

    if (poa < mrnd ) {
        System.out.println("accept change");
    };
    if (poa > mrnd )  {
        System.out.println("deny change");
    }

    if (o % 6 == 5) {
        x = x-z;
    }
}