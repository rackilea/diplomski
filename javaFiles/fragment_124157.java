for (int i=2; i<=number;i++){
            for (int j=2; j<i;j++){
                if (i%j==0){
                    isPrime=false;
                    break;
                } 
            }
        }
        if (isPrime(i)){
            System.out.println(i);
            counter++;
        }