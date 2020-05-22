int i=0;
while(i < userInput.length()){
    System.out.printf("* %42s *\n", userInput.substring(i, Math.min(i + 42, userInput.length())));
    i += 42;
}
while(i < 336){
    System.out.println("*                                            *");
    i+=42;
}