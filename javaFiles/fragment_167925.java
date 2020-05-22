final Button anotherButton = (Button) findViewById(/*your_another_button_id*/);
view.setOnClickListener(new OnClickListener
({
    @Override
    public void onClick(View view) 
    {
        TranslateAnimation animate = new TranslateAnimation(0,0,0,anotherButton.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        anotherButton.startAnimation(animate);
        anotherButton.setVisibility(View.GONE);
    }
}));