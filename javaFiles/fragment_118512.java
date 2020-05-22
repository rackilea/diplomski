mLinearLayout=(LinearLayout)findViewById(R.id.mainLinearView);

    mLinearLayout.removeAllViews();

   for(int i=0;i<4;i++){
        mLinearLayout.addView(createViewTOAdd(), i);
    }