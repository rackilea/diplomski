String tmpStr1 = "";

try {
     tmpStr1 = s1.nextLine();
     columns = tmpStr1.split("");
     //access array items
}
catch (ArrayIndexOutOfBoundsException aEx) {

    System.out.println(aEx.getMessage());
    //print the whole like that was read from the file
    //this will help you to understand what went wrong
    System.out.println(tmpStr1);
}