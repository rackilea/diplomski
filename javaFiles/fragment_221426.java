for (int i = 0; i < array1.length; i++){
    System.out.println(i+1 + ": ");
    input = TextIO.getlnDouble();   // Retrieves input
    array1[i] = input;
}

System.out.println("Please enter the first number in the 2nd set: ");

for (int i = 0; i < array2.length; i++){
    System.out.println("Number: ");
    input = TextIO.getlnDouble();   // Retrieves input
    array2[i] = input;
}