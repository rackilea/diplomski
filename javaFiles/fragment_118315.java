ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(10);
    numbers.remove(new Integer(5));
    System.err.println(numbers);
    //Prints [10]