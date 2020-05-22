Button food = (Button) findViewById(R.id.food);
food.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
       Intent foodIntent=new Intent(CurrentActivity.this,OtherActivity.class);
       foodIntent.putExtra("intent","foodButton");
       startActivity(foodIntent);
    }
});

Button anima = (Button) findViewById(R.id.anima);
anima.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
       Intent animaIntent=new Intent(CurrentActivity.this,OtherActivity.class);
       animaIntent.putExtra("intent","animaButton");
       startActivity(animaIntent);
    }
});

Button hob = (Button) findViewById(R.id.hob);
hob.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
       Intent hobIntent=new Intent(CurrentActivity.this,OtherActivity.class);
       hobIntent.putExtra("intent","hobButton");
       startActivity(hobIntent);
    }
});