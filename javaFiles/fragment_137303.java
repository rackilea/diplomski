protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.theme);

    if(Constants.water==1){


        res = getResources(); 
        drawable = res.getDrawable(R.drawable.water_theme); 
        linearLayout =   (LinearLayout)findViewById(R.id.ll); 
        linearLayout.setBackgroundDrawable(drawable);
        }
        else if(Constants.fire==1){
            res = getResources(); 
            drawable = res.getDrawable(R.drawable.fire_theme); 
            linearLayout =   (LinearLayout)findViewById(R.id.ll); 
            linearLayout.setBackgroundDrawable(drawable);
    }
        else{
            res = getResources(); 
            drawable = res.getDrawable(R.drawable.ic_launcher); 
            linearLayout =   (LinearLayout)findViewById(R.id.ll); 
            linearLayout.setBackgroundDrawable(drawable);
    }

}