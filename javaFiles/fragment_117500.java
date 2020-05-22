Random rand = new Random();
    int num1 = rand.nextInt(1000);
    int num2 = rand.nextInt(1000);
if(num1<num2){
    Operation operation = generateRandOperation();
    while(operation == Operation.SUBTRACTION||operation == Operation.DIVISION){
          Operation operation = generateRandOperation();  
    }
}
else{
     Operation operation = generateRandOperation();
}
if(operation == Operation.DIVISION){
    if(isPrime(num1)){
        num1++;
    }
    while(((num1%num2)!=0)&&num1<num2){
        int num2 = rand.nextInt(1000);
    }
}