//also assuming you will set the results in a Data class (yes, this can be replaced)
Data data = null;
if (rs.next()) {
    //logic to retrieve data...
    data = new Data();
    data.setSomething(rs.get(1));
    //more and more code to fill the data...

    //because it looks that you need it as String (wonder why you return a String as well)
    return data.toString();
}
//note: I use an else statement to check if indeed there were no results at all
//else statement added using a line separator for code explanation purposes
else {
    m = "ID not found.";
    return m;
}