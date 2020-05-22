java.io.File file = new java.io.File("C:\\Users\\Mike\\Desktop\\data.txt");
try {
    Scanner input = new Scanner(file);
    ArrayList<Double> list = new ArrayList<Double>(); // define empty ArrayList

    while(input.hasNextLine()) {
        list.add(input.nextDouble()); // have to change the lines
    }

    // convert ArrayList to array
        // (although you don't need to do this if you're fine with an ArrayList)
    double[] array = new double[list.size()];
    for (int i = 0; i < list.size(); i++) {
        array[i] = list.get(i);
    }

    // print out the array
    for (double d : array) {
        System.out.println(d);
    }

} catch (Exception e) {
    e.printStackTrace();
}