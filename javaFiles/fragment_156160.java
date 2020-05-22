public void initialVocabList(View view) {

    // ADD HERE
    vocabListView = (ListView)view.findViewById(R.id.vocabList);
    //vocabsList = new ArrayList<String>();
    //retrieve from SharedPreferences
    TinyDB tinydb = new TinyDB(getBaseContext());
    vocabsList = tinydb.getListString("vocabs");
    //itemsAdapter = new ArrayAdapter<String>(this, R.layout.vocab_notes_item, items);
    itemsAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.vocab_notes_item, vocabsList);

    vocabListView.setAdapter(itemsAdapter);    

    // Setup remove listener method call
    setupListViewListener();
    // Setup Onclick method call
    setOnClickListener();
}