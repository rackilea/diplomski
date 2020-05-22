radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String text = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        }
    });*