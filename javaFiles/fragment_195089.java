public static int persistence(long n) {
    long num = 0;
    if(n > 10){
        while(!((digits.get(0) / 10) >= 1)){ 
            splitNumbersUp(n);
            num = multiply(digits.size());
            clearDigits();
            digits.push(num);
        }
...