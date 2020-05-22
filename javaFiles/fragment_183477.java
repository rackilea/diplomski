Intent intent = getIntent();
    String value = null;
    if (intent.getData() != null)
    {
        value = intent.getData().getQueryParameter("server"); 
    }
    if (value != null)
    {
        Log.d(TAG, "with scheme value: "+ value);
        if (value.equals("my_test_server_address"))
        {
            Toast.makeText(this, "Server set to Test" , Toast.LENGTH_LONG).show();
        }
        else if (value.equals("my_production_server_address"))
        {
            Toast.makeText(this, "Server set to Production" , Toast.LENGTH_LONG).show();
        }
        else
        {   
            Toast.makeText(this, "Server set to Address: "+ value , Toast.LENGTH_LONG).show();
        }
        Consts.BASE_URL = Uri.parse(value);
    }
    else
    {
        Log.d(TAG, "value was null");
    }