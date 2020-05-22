yourRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                    switch (checkedId){
                        case R.id.radio_one:
                            stufe = 1;
                            break;
                        case R.id.radio_two:
                            stufe = 2;
                            break;
                        default:
                            break;
                    }
                    textView2.setText(String.valueOf(stufe));
            }
        });