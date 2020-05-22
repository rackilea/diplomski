View selectedView = null;  //Declare it as a class level variable so that you don't need to make it final  

spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selectedView = view;
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });