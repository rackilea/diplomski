public void onDataChange(DataSnapshot dataSnapshot) {
    //Toast.makeText(PlayTest.this, "FIN QUI ",Toast.LENGTH_SHORT).show();
    final int[] ndomande = {14};

    for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
        //Toast.makeText(PlayTest.this, "QUI ",Toast.LENGTH_SHORT).show();

        long numero_domande = (long) messageSnapshot.getValue();
        ndomande[0] = (int) numero_domande;

        Toast.makeText(PlayTest.this, "quante domande ci sono totali: "+ numero_domande,Toast.LENGTH_SHORT).show();
    }
}