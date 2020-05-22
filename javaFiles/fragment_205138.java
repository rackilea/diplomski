public CardFragment cardFragment;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     createDummyCards();
     cardFragment = (CardFragment) 
         getSupportFragmentManager().findFragmentById(R.id.frgCard);
     cardFragment.setCard(cardApples);
 }