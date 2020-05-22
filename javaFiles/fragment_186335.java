//String[] HelveticaTextArray = {"Nike", "Puma", "Adidas", "Reebok", "Umbro"};
int[] HelveticaTextArray = {R.id.Nike, R.id.Puma, R.id.Adidas, R.id.Reebok, R.id.Umbro}


for ( int[] HelveticaTextArray : item ) {
    final TextView HelveticaText = (TextView)findViewById(item);
    HelveticaText.setTypeface(Helvetica);
};