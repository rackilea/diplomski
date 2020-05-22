//Parent View
LinearLayout sv = (LinearLayout) findViewById (R.id.LinearLayout1); 

//infalter service
LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//Loop to create all the child views
for (int i=0; i<=3; i++) {

//Refrence your layout xml here
LinearLayout childView= inflater. inflates (R. layout. your_xml, null);

//Get refrence to your button and imageview using childView

//add child view 
sv.addView(childView);
}
//add sv to horizontal scroll view