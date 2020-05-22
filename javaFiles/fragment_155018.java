// get newEventButton    
Button addEvent = (Button) findViewById(R.id.newEventButton);
// Listen for button click and start AddEventActivity 
addEvent.setOnClickListener(new onClickListener()
{
    @Override
     public void onClick(View v)
     {
         startActivity(new Intent(this, AddEventActivity.class);
     }
 });