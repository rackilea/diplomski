List<String> suggestions = new ArrayList<>();
  ArrayAdapter<String> adapter ;
   .
   .
   .
   // in your onCreate

   autocomplete = (AutoCompleteTextView)findViewById(R.id.stocks);
   adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_dropdown_item_1line, suggestions);
   autocomplete.setAdapter(arrayAdapter);

   autocomplete.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
          //retrieveData(s);
        }

        @Override
        public void afterTextChanged(Editable s) {
            retrieveData(s); //this will call your method every time the user stops typing, if you want to call it for each letter, call it in onTextChanged 

        }
    });
   .
   .
   .
   // where you get the data, I suppose in a list
   private void retrieveData(String s){
    //Do your stuff here with the String s and store the list of your results in the list suggestions
   suggestions = yourList;
   adapter.notifyDataSetChanged();

   }