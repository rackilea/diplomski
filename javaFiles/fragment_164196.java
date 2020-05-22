String[] courseArray = new String[4];
    {
        courseArray[0] = "Preddiplomski studij Menadžment";
        courseArray[1] = "Preddiplomski studij Promet";
        courseArray[2] = "Preddiplomski Upravni studij";
        courseArray[3] = "Specijalistički studij Menadžment";
    }

    ArrayAdapter courseAdapter = new ArrayAdapter(this,
            android.R.layout.simple_spinner_item, courseArray);
    courseAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
    courses.setAdapter(courseAdapter);

    courses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {

            //Get item from Spinner and store in string conductorSize........
            cors = parent.getItemAtPosition(pos).toString();
            if (cors.equals(courseArray[0])) {
                ectsPrice.setText("200");
                price = 200;
            } else if (cors.equals(courseArray[1])) {
                ectsPrice.setText("250");
                price = 250;
            } else if (cors.equals(courseArray[2])) {
                ectsPrice.setText("300");
                price = 300;
            } else if (cors.equals(courseArray[3])) {
                ectsPrice.setText("350");
                price = 350;
            } else {
                //Do nothing
            }
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    });
}