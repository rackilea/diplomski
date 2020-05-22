int[] accumulator = new int[3]; // create a new array
for (int i = 0; i < 3; i++) { // loop 
    int num = (int) (Math.random() * (6)+1); 
    accumulator[i] = num; // assign the random number 
   System.out.println(accumulator[i]); // print to console
}