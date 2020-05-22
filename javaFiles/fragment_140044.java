int count = 0;
for(int iteration = 1; iteration <=10; iteration ++) {
   Random number = new Random(); 
   int n = number.nextInt(10);
   if(n == val) count++;
}
System.out.println("The number " + val +" was found " + count + "  number of times");