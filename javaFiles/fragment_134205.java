textView.setText("End");
        setContentView(textView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, result_arr);
        lvMain.setAdapter(adapter);