yourCheckboxView.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (isChecked){
                   Intent i = new Intent(this, 2nd java.class);
                   startActivity(i);
            }
        }

    });