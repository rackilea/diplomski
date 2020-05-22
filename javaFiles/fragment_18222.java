public static void numberFactorial() {  
    System.out.println("Option 2 selected, enter a number: "); 
    int number = sc.nextInt(); 
    if(number < 0){
         throw new IllegalArgumentException()
    }
    // ... rest of the code
}