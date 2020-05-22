public static void createDoublesArray(){
    doubles = new double[SIZE];
    //Create Random object 
    Random r=new Random(); 
    double rangeMin = 1, rangeMax = 9; 
    //Generate random double number - 20 times within the range of 2 to 9

    double randomdouble = 0.0;  // <- we don't want to initiate double in 'for' loop

    for(int i=0;i<SIZE;i++) { 
        //Generate random double numbers and round them to the two decimal places
        randomdouble = Math.round((rangeMin + (rangeMax - rangeMin) * r.nextDouble())*100.0)/100.0; 
        doubles[i] = randomdouble;            
    }         
}