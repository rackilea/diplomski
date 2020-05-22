ground.setOnItemSelectedListener(new OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

           if(parent.getItemAtPosition(pos).toString().equalsIgnoreCase("Combination"))
            {
              combo.setVisibility(View.VISIBLE);
            }
        }

        public void onNothingSelected(AdapterView parent)
        {
            // Do nothing.
        }
    });