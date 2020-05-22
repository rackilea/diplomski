public static long factorial(long number){
         if (number == 0) // test for base case
         {
             return 1;
         } else {// recursion step
             if (s.length() == 0) {
                 s.append(number).append("*").append(number - 1);
             } else {
                 String spaces = "";
                 for (int i = 0; i < number; i++) {
                     spaces = spaces+" ";
                 }
                 if(number==1)
                    System.out.println(" Base Case: 1");
                 else {
                    System.out.println(spaces + "Recursive call:" + number + " * fact(" + (number - 1) + ")"); 
                    s.append("*").append(number).append("*").append(number - 1);
                 }
             }
        return number * factorial(number - 1);
         }
     }

public static void main(String[] args) {
    System.out.println("Hannah Coffey - Lab 6");
    // calculate the factorials of 0 through 20
    for (int counter = 0; counter < 25; counter++) {
        s = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            spaces = spaces+" ";
        }
        System.out.println(spaces+"Recursive call:"+counter + "!");
        System.out.printf("%d! = %d%n", counter, factorial(counter));
    }
}