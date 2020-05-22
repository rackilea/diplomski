String[] rank =  // ...
int rankIndex = new Random().nextInt(rank.length);
String randomRank = rank[rankIndex];

String[] suit = // ...
int suitIndex = new Random().nextInt(suit.length);
String randomSuit = suit[suitIndex];

System.out.println("The card you picked is " + randomRank + " of " + randomSuit);