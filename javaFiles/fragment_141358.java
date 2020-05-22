Intent i = new Intent(this, secondActivity.class);
    //Create the bundle
Bundle bundle = new Bundle();
//Add your data from getFactualResults method to bundle
bundle.putString("TAG", yourvalue);
//Add the bundle to the intent
i.putExtras(bundle);
startActivity(i);