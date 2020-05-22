test1 = true;
while (test1) {
  while(test1) { // <-- like that, not = true){
    System.out.println("test1");
    testString = UI.nextLine();
    if(testString.equals("Hello World")){
        test1 = false;
        test2 = true;
    }
  }
  while(test2) { // <-- like that, not = true){
    System.out.println("test2");
    testString = UI.nextLine();
    if(testString.equals("GOTO 1")){
        test2 = false;
        test1 = true; // <-- I assume that's what this was for.
    }
    // Note infinite loops now. test2 is only false with GOTO 1.
    // Which loops again.
  }
}