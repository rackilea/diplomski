radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup rg, int checkedId) {
            for(int i=0; i<rg.getChildCount(); i++) {
                RadioButton btn = (RadioButton) rg.getChildAt(i);
                if(btn.getId() == checkedId) {
                    String text = btn.getText().toString();
                    // do something with text
                    Toast.makeText(demo.this,text,Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
    });