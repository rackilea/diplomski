double sum = 0;
for(String[] row: rowsAsTokens) {
    // check the first row is HELLO
    if(row[0].equals("HELLO")) {
        // get the second row as a double
        sum += Double.parseDouble(row[1]);
    }
}
// print the grand total once at the end
System.out.println(sum);