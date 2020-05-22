String[] sourceArr = {"A", "B", "C"};
    List<String> list = Arrays.asList(sourceArr);
    System.out.println(list); // [A, B, C]

    sourceArr[2] = ""; // changing source array changes the exposed view List
    System.out.println(list); //[A, B, ]

    list.set(0, "Z"); // Setting an element within the size of the source array
    System.out.println(Arrays.toString(sourceArr)); //[Z, B, ]

    list.set(3, "Z"); // java.lang.ArrayIndexOutOfBoundsException
    System.out.println(Arrays.toString(sourceArr));

    list.add("X"); //java.lang.UnsupportedOperationException

    list.remove("Z"); //java.lang.UnsupportedOperationException