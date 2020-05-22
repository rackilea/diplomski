int numSales = 0;  // set initial value in case numPeople is 0 and the loop never runs

    // loop through the sales people    
    for(int j = 0; j < numPeople; j++) {

        // ask for the sales for the current vacation and read it in
        System.out.println("What are the sales for the current vacation by person #" + Integer.toString(j+1) + "?:");
        numSales = input.nextInt();  // line 42; this value is never used?  it is overwritten below

        // overwrite the never-used value from line 42?? 
        numSales = vacay.updateSales(); 

    } //end of inner loop

    // now numSales is still visible, because it was declared on this same 'level' and not in an inner block
    System.out.println("numSales: " + numSales);