// Get a random number <= 100
 Random r = new Random();
 Integer n = r.nextInt(100);

 // Get the network allocations
 Integer allocation_network1 = 50;
 Integer allocation_network2 = 40;
 Integer allocation_network3 = 10;

 // Choose which network to use
 if (n <= allocation_network1) {
    // Display ad network1 Ad
 } 
 else if (n <= allocation_network1 + allocation_network2) {
    // Display ad network2 Ad

 } 
 else if (n <= allocation_network1 + allocation_network2 + allocation_network3){
 }