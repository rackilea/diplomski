gedungSpn.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                    int position, long id) {
                if (position == 0){
                   LantaiSpinnerRektorat();
                 }else if(position == 1){
                   LantaiSpinnerGL();
                 }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub

            }
        });