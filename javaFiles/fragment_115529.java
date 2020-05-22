ArrayList<String[]> data = new ArrayList<String[]>();
while( myScanner.hasNextLine()) {
    //get one row   
    String oneRow = myScanner.nextLine();
    //then split the line by comma
    String[] oneSplitRow = oneRow.split(",");
    //add your data to the arraylist
    data.add(oneSplitRow);
}
// now to make the Object[][]
Object[][] theData = new Object[data.size()][data.get(0).length];
// and here is where you can iterate through the data arraylist and put
//  the strings into theData 2d array
// ..... your code here