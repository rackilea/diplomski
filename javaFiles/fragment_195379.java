lv.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // When clicked, show a toast with the TextView text
                            Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                            // Start a new intent - get the id from the view and send to another activity for JSON
                            // selected item
                            String product = ((TextView) view).getText().toString();

                            // Launching new Activity on selecting single List Item
                            Intent i = new Intent(getApplicationContext(), DrugIndexing_view.class);
                            // sending data to new activity
                            i.putExtra("product", product);
                            startActivity(i);
                            // End intent
                    }

            });