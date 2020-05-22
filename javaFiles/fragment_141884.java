EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

         public void afterTextChanged(Editable s) {
         }

         public void beforeTextChanged(CharSequence s, int start, 
           int count, int after) {
         }

         public void onTextChanged(CharSequence s, int start, 
           int before, int count) {
          sca.getFilter().filter(s.toString());
         }
        });

        sca.setFilterQueryProvider(new FilterQueryProvider() {
               public Cursor runQuery(CharSequence constraint) {
                   return mdb.fetchMyValues(constraint.toString());
               }
           });