String selected = "0"; // defined outside the function scope
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                    Log.v(TAG, "OnItemselected started");

                    switch (position) {
                    case 0:
                        selected = "10".toString(); 
                     Break;
                   }
               }

    float number = Float.valueOf(selected);