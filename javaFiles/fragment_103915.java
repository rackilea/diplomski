ArrayList<Integer> numbers = new ArrayList<Integer>();

    System.out.println("Enter the numbers you want to test, enter 'stop' to stop");
    boolean userInput = true;

    while(input.hasNextInt() && userInput){
        if(input.hasNext("stop")){userInput = false;}
        numbers.add(input.nextInt());
        }