Scanner input = new Scanner();

String nameEntry = null;   //  enter the name
int vanIndex = 0;     //  index of van
boolean wordPresent = false;  //  word search all over

System.out.print("Enter your name :");
nameEntry = input.next();

vanIndex = nameEntry.indexOf("van");

if(vanIndex > 0){
    wordPresent = true;
}

if(wordPresent){
//do whatever
}