//create an Intent object 
        Intent intent=new Intent(context, Activity.class);
    //add data to the Intent object
        intent.putExtra("text", "Data");
    //start the second activity
        startActivity(intent);