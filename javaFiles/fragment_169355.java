for(int i=1; i< 113; i++){
        String numberString = "" + i;
        if (isOdd(i) == true){
            numberString += ", is odd";
        }
        else{
            numberString += ",";
        }
        if (isDivisibleBy5(i) == true){
            numberString += ", is even"
        }
        if(isPrime(i) == true){
            numberString += "Prime";
        }
        if(isDivisibleBy7(i+(i+1))==true ){
            numberString += "wow";
        }
        al.add(numberString);
    }