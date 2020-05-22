@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        final Spinner spinner = (Spinner) menu.getItem(0).getActionView().findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                String items = spinner.getSelectedItem().toString();
                Log.i("Selected item : ", items);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
        return super.onCreateOptionsMenu(menu);
    }