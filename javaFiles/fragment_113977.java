@Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if(isChecked){
                        switchStatus.setText("Sorting alphabetically");


                        Collections.sort(categories, new Comparator<Categories>() {
                            @Override
                            public int compare(Categories lhs, Categories rhs) {
                                return lhs.title.compareTo(rhs.title);
                            }
                        });


                        ca.notifyDataSetChanged();


//JUST ADDED THIS SHARED PREFERENCE WITH THE STRINGS ("it's","on") WHEN THE SWITCH IS ON

                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("it's","on");
                        editor.apply();

                    }else{
                        switchStatus.setText("Sorting by popularity");

                        Collections.sort(categories, new Comparator<Categories>() {
                            @Override
                            public int compare(Categories rhs, Categories lhs) {
                                return lhs.title.compareTo(rhs.title);
                            }
                        });

                    ca.notifyDataSetChanged();

    //JUST ADDED THIS SHARED PREFERENCE WITH THE STRINGS ("it's","off") WHEN THE SWITCH IS OFF

                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("it's", "off");
                        editor.apply();
                    }

                }
            });