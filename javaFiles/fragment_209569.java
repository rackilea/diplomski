for(int i=0; i<52; i++) {
    System.out.println(deck2[deck3[i]]);
}

or you can read the value first and then use it

for(int i=0; i<52; i++) {
    int randomIndex = deck3[i];
    System.out.println(deck2[randomIndex]);
}