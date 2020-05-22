//Make this a member variable:
ArrayList<String> chequeList;

//in onCreate:
Intent i = getIntent();      
chequeList = i.getStringArrayListExtra("cheque_list");