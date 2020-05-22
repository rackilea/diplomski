int handValue; 
for(int z = 0; z<hand.size(); z++){ //iterate through cards in hand
    Cards card = hand.get(z);       //to add values and check if bust (21)
    Rank rank = card.getRank();  // better make sure Card has this method
    int points = rank.RankPoints();
    handValue += points;

    // check now that it's not > 21
    // ?? System.out.println(valueofcards);
}