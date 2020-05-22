for(i=0; i<values.length; i++){ // <-- this is a good place for it.
    System.out.print("Enter a number between 70 and 90: ");
    values[i] = scanner.nextInt();
    // i++; // only need one.
    // if(i == 6){
    //    break;
    // }
    sum += values[i]; // <-- you can use += too
}