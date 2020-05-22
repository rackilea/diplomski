public int getHighest(int[] array) {
    String output = new String("");
    int highest = array[0];
    for(int i = 1; i < array.length; i++) {
        if (array[i] > highest)
            highest = array[i];
            //Removed from here
            //System.out.println("The highest score=" + highest);
    }
    //Moved to here
    System.out.println("The highest score=" + highest);
    return highest; 
}