//for each where we get back values from sting set, then convert to product 
    for (String id : myJson) {
        StackProduits savedProduct = gson.fromJson(id, StackProduits.class);
        listProduits.add(savedProduct);
    } 
    adapterFavoris = new ProduitsAdapter(getApplicationContext(), -1, listProduits);
    produitFavorisListView.setAdapter(adapterFavoris);