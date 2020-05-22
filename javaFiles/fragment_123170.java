public static int sqrt(double number){

        double g1;

       if(number==0){
            return 0;
        }

        double squareRoot = number/2;

        do{

            g1=squareRoot;
            squareRoot = (g1 + (number/g1))/2;

        }while((g1-squareRoot)!=0);

           return (int) squareRoot;

    }