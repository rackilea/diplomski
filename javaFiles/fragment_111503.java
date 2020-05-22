if("animals".equalsIgnoreCase(type)){      

    ImageView fieldSwamp = (ImageView) findViewById(R.id.btnSwamp);
    ((LinearLayout)fieldSwamp.getParent()).removeView(fieldSwamp);

    ImageView fieldGrass = (ImageView) findViewById(R.id.btnGrass);
    ((LinearLayout)fieldGrass.getParent()).removeView(fieldGrass);          

} else {
Log.e("type","didn't remove views.");
}