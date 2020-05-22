while (rowsLeft) {
    readRow = reader.readLine();
    if (readRow == null) {
       rowsLeft = false;
    } else {
       //Convert the String into a Number (int or float depending your input)
       //Saving it on a list.
       System.out.println(readRow);
    }
}


//Now iterate over the list adding all your numbers
//Divide by the size of your list
//Voila
System.out.println("Average: ");
reader.close();