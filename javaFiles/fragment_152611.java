final Button buttonStudy = (Button) findViewById(R.id.button_study);
buttonStudy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ViewGroup.LayoutParams params = buttonStudy.getLayoutParams();
        params.width = 100;//change the width size
        params.height= 100;//change the hight size
        buttonStudy.setLayoutParams(params);
    }
});