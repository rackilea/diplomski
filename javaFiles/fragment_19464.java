try {
    BufferedReader infixLines = new BufferedReader ( new FileReader ( "input.infix" ));
    // other reading code here
}
catch (FileNotFoundException e){
    System.out.println(e);
}
catch (IOException e){
    System.out.println(e);
}