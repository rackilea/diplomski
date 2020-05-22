//Set the click listener to launch the browser when a row is clicked. 
produitFavorisListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override 
    public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
        Intent intentProduitFavorisDetail = new Intent(Favoris.this, ProduitDetail.class);
        StackProduits ProduitFavoris = ProduitsXmlPullParser.getStackProduitFromFile(Favoris.this).get(pos);
        intentProduitFavorisDetail.putExtra("produit", ProduitFavoris);
        startActivity(intentProduitFavorisDetail);
    } 
});