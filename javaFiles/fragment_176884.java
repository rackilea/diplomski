int userInput = promptForInt("Length Of board");
int [] numbers = new int[userInput];
boolean showItem = false;
int display = displayBoard(board [], boolean showItem);

int randomlocs = new Random().nextInt(userInput); //since this isn't used before the method call, it should be declared below it
int guess = 0; //same with this
int val; //and this