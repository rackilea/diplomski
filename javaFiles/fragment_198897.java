@Override
    public void onClick(View view) {
        boolean canGenerate = true;
        ArrayList<String> errors = new ArrayList<String>();

        switch(view.getId()) {
        case R.id.bNewNext:
            if(cityName.getText().toString().matches("")) {
                errors.add("! Settlement must have a name.\n");
                canGenerate = false;
            }

            if(specific.isChecked() && customPop.getText().toString().matches("")) {
                errors.add("! Enter a population figure.\n");
                canGenerate = false;
            }           
            break;
        }

        if(canGenerate) {
            // Here, you should run this method first
            sendCityData(cityName.getText().toString());
            gen = new Generator(getBaseContext());
            errors.clear();
            gen.createCity();
        } else {
            StringBuilder builder = new StringBuilder();
            for(String value : errors) {
                builder.append(value);
            }           
            errorList.setText(builder.toString());
            errors.clear();
        }
    }