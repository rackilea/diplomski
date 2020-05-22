for(int i=0; i<numbersArray.length; i++) {

    String[] numbers= numbersArray[i].split(" "); //split on " "
    //here you will get [1,2,3] for first iteration and 2nd [4,5,6], last [1,8]

    ArrayList<Integer> a1 = new ArrayList<Integer>();
    for(int j=0; j<numbers.length; j++) {
        a1.add(new Integer(numbers[j]));
        //here adding inner array list elements

    }
    //add to main array list 
    a.add(a1);
}