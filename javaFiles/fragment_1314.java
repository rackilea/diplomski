public void eurozweichange (View view) 
{
    setContentView(R.layout.activity_main); //this was missing
                //i think it wont work because layout with ID was not loaded.
    ImageView picturetochange= (ImageView) findViewById(R.id.iveuro);
    picturetochange.setImageResource(R.drawable.eurozwei);
}