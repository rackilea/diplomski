spinner= findViewById(R.id.spinner);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ((TextView) adapterView.getChildAt(0)).setTextColor(getResources().getColor(R.color.black));
                ((TextView) adapterView.getChildAt(0)).setTextSize(19);            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });