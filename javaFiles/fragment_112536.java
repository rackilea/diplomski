double num1 = 0;
String input1 = sc1.nextLine();
if(input1.compareToIgnoreCase("quit") == 0) {
    // quit was entered, leave the loop
    quit = true;
    continue;
}
try {
    num1 = Double.parseDouble(input1);
} catch(NumberFormatException e) {
    // user entered something that isnt a number, quit the program for now
    // you can change this to whatever behavior you like in the future
    quit = true;
    continue;
}