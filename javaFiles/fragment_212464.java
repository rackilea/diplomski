pinRoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch(selectedUserRole) {

               case 0:
                      Log.i(TAG, "Anonymous");
                      // Code
                   break;

               case 1:
                      Log.i(TAG, "Owner");
                      // Code
                   break;

               default;
                     // Code
                   break;

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });