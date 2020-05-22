public void onClick(View v)
{
    switch(v.getId()){
    case (R.id.button1):

        RelativeLayout rootLayout = (RelativeLayout)findViewById(R.id.main_layout);

        //use layout inflater to create 'spinnerNew' on the fly
        final LayoutInflater spnInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        spinnerNew = (Spinner)spnInflater.inflate(R.layout.extra_spinner, null);
        rootLayout.addView(spinnerNew);

        //move the dynamic spinner to different position
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)spinnerNew.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.BELOW, R.id.spinner1);

        spinnerNew.setLayoutParams(params); //causes layout update

        //use layout inflater to create 'remove button' on the fly
        final LayoutInflater btnInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        buttonRem = (Button)btnInflater.inflate(R.layout.btn_remove, null);
        rootLayout.addView(buttonRem);

        //move the dynamic button to different position
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams)buttonRem.getLayoutParams();
        params1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params1.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.spinnerNew);
        buttonRem.setLayoutParams(params1);
        buttonRem.setOnClickListener(this);//<-------------set onclick here
    break;

    case(R.id.buttonRem):
        //spinnerNew.setVisibility(View.GONE); //does nothing
        //buttonRem.setVisibility(View.GONE);//does nothing
        ViewGroup layout = (ViewGroup) spinnerNew.getParent();
        if(null!=layout) 
           layout.removeView(spinnerNew);//does nothing
    break;
    }
}