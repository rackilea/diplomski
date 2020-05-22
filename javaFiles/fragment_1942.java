@Override 
protected void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) { 
        // Activity was brought to front and not created, 
        // Thus finishing this will get us to the last viewed activity 
        finish(); 
        return; 
    } 

}