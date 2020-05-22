button.setOnClickListener(new OnClickListener() {


    @Override
    public void onClick(View button) {


        Intent act2= new Intent(ActivityB.this,ActivityA.class);
            act2.putExtra("myImageResource", R.drawable.other_image);
            startActivity(act2);    
        }




    }); 
 }