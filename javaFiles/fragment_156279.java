private void setMap(){
    // print headers
    System.out.printf("%5s%12s%10s%8s\n","Array", "LinkedList",
            "ArrayList", "Vector");
    for (int i = 0; i < numberTimes; i++){

        // put calculated time into hashmap
        map.put("Array", timer.arrayTimes());
        map.put("LinkedList", timer.linkedTimes());
        map.put("ArrayList", timer.listTimes());
        map.put("Vector", timer.vectorTimes());                          

        // Loops through each element of map.values() and assigns its value to the val variable
        for(String val : map.values()){
            System.out.printf("%-10d", val);
        }                          
        System.out.println();                          
    } // end for                                    
}