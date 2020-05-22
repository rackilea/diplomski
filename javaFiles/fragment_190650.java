Bundle i = getIntent().getExtras();

    if(i!=null)
    {
        int a = i.getInt("mScore"); // in first activity you are putting integer values 
        Toast.makeText(getApplication(), String.valueOf(a), Toast.LENGTH_SHORT).show();
    }