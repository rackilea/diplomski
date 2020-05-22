ArrayList<String> myArray = new ArrayList();

    myArray.add("A");
    myArray.add("A");
    myArray.add("B");
    myArray.add("B");
    myArray.add("B");
    myArray.add("C");
    myArray.add("C");
    myArray.add("D");
    myArray.add("D");
    myArray.add("D");

    //the above will output: A,A,B,B,B,C,C,D,D,D

    System.out.println(myArray);

    String rotateTo = "C";

    int distance = -1;

    for (int i = 0; i < myArray.size(); i++) {
        String item = myArray.get(i);
        if(item.equals(rotateTo)){
            distance = i;
            break;
        }
    }

    //you can use distance = myArray.indexOf(rotateTo);
    //to get index rather than above for loop
    //Check Jerry Ans.


    if (distance != -1) {
        //this gives me random unwanted results...
        Collections.rotate(myArray, distance);
    }

    System.out.println(myArray);