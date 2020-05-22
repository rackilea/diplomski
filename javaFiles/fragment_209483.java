int player1points = 0;
int player2points = 0;
int count = 0;
int mostCommon = 0;
int maxCount = 0;
ArrayList<Integer> diceRolls = new ArrayList<Integer>();
Scanner in = new Scanner(System.in);
Random n1 = new Random();

//rollDice method (parameter would be number of dice to roll)

//checkResults method (count number of times each number 1-6 shows up)

if(maxCount == 3){
    player1points += 1000;
    //re-roll 2 dice if necessary
else if(maxCount == 5){
    player2points += 2000;
    //re-roll dice if wanted