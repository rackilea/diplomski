java.io.File file = new java.io.File(file);
int size = 0;
int i = 0;
try {
    Scanner input = new Scanner(file);
    while(input.hasNextLine()){
        input.nextLine(); // have to change the lines
        size++;
    }    
    double [] array;
    array = new double [size];

    // reopen the file so you start from the beginning again
    input = new Scanner(file);

    while(input.hasNext()){
        array[i] = input.nextDouble();
        i++;
    }

    // print out the array
    for (double d : array) {
        System.out.println(d);
    }

} catch (Exception e) {
    e.printStackTrace();
}