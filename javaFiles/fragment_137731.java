//first declare arrays
// create a deck of 52 cards
String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
                   "Jack", "Queen", "King", "Ace"
                 };

//then find out their length
int suits = suit.length;
int ranks = rank.length;
int n = suits * ranks;
//counter
int m = 5;