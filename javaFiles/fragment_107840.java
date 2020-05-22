public static boolean isListClicked=false;
public static String favorite_message ="";

listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            // TODO Auto-generated method stub
           isListClicked=true; 
           favorite_message =(String)parent.getItemAtPosition(position);
           //set second fragment in your viewpager by below line
           YOURACTIVITY.YOUR_VIEW_PAGER.setCurrentItem(1);
            Log.d("hi","favorite" + favorite_message);
            //Populate the edit text of Fragment1
        }
    });