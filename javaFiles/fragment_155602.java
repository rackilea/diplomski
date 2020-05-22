bt_Goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ed_text.getText().toString().length() > 0){
                    mViewPager.setCurrentItem(Integer.parseInt( ed_text.getText().toString()));
                }
            }
        });