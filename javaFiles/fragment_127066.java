ListView mainListview = new ListView(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_single_choice,  new String[]{"Search","Options"});
            mainListview.setAdapter(adapter); /// your adapter here
            mainListview.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                        long arg3) {

        ///doYourSpinnerStuff(arg1) here

                    }

                            });