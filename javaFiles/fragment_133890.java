spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
          // Enable Spinner 2
          // Set spinner 2 adapter
      }

      @Override
      public void onNothingSelected(AdapterView<?> parentView) {
          // Disable spinner 2
          // Set spinner 2 adapter to empty list
      }
});