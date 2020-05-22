List<CardView> cards = new ArrayList<CardView>();
for (int i = 1 ; i <= cardsCount ; i++)
{
    int id = getResources().getIdentifier("msgBot"+i+"v", "id", context.getPackageName());
    cards.add((CardView) findViewById(id));
}