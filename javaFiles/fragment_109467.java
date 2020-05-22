List<Integer> lineNumbers = new ArrayList<Integer>();
int lineNumber = 0;
while ( line != null ){
    lineNumber++;
    if ( line.indexOf(searchString) != -1 ){
        lineNumbers.add(lineNumber);
    }
    line = br.readLine();
}
if ( lineNumbers.size() > 0 ){
    //do something with them
}