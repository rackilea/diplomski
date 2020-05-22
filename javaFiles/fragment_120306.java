final RadioGroup radioSexGroup = (RadioGroup) findViewById(R.id.radiogender);

    final TextView m = (TextView) findViewById(R.id.gender);

    radioSexGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup arg0, int selectedId) {
             selectedId = radioSexGroup.getCheckedRadioButtonId();

            RadioButton radioSexButton = (RadioButton) findViewById(selectedId);
            m.setText(radioSexButton.getText());

        }
    });