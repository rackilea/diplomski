Random rnd = new Random();
double x=0;
do{
    x = rnd.nextDouble()*100;
}while(x>20 && x<50 );

    System.out.println(x);
    }