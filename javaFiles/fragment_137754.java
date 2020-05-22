rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                spinner1.setVisibility(View.VISIBLE);
                spinner1.setClickable(true);
            }
            else {spinner1.setVisibility(View.GONE);
                spinner1.setClickable(false);}
        }
    });