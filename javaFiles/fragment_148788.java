public int addNumbers(int... numbers) {
     //can reference them in here as an array
     if(numbers.length == 0) return 0; //empty sum
     int sum = 0;
     for(int number: numbers) {
         sum += number;
     }
     return sum;
}