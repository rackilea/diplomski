try{
    checkLineLength(line.length()); // call to the method
}
catch(Exception e){
     e.printStackTrace(); // print the stacktrace if exception occurs
     System.exit(1);
}