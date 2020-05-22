rbHide = (RadioButton)findViewById(R.id.rbHide);
rbShow = (RadioButton)findViewById(R.id.rbShow);

RadioGroup rg = new RadioGroup(this);
rg.addView(rbHide);
rg.addView(rbShow);
rbHide.setOnCheckedChangeListener(this);
rbShow.setOnCheckedChangeListener(this);