public Deck() {
   this("default_deck_name");
   //this will call the current Class' constructor which has a String Parameter, --> Deck(String name) 
}

public Deck(String name) 
{
   super(name);
   //this will call the Parent Class(CardList)'s constructor which has a String parameter

   for (int i = 0; i < 4; i++) {
     for (int j = 2; j < 15; j++) {
       addCard(new Card(j,i));
     }
   }
}