Button b;
ToggleButton tog;

@Override
protected void onCreate(Bundle savedInstanceState) {
    arnavbhai();
    tog.setOnClickListener(this); 
    b.setOnClickListener(this);   <-- seems this part is throwing NPE
}

private void arnavbhai() {
    b = (Button) findViewById(R.id.button1); <-- shouldn't it be R.id.bresults ?
    tog = (ToggleButton) findViewById(R.id.togglebutton);
}