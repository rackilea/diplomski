View rootView;
     onCreateView(){
        rootView=inflate(" inflate your view here");
        return rootView;

     }
     onResume(){
           TextView textView=(TextView)rootView.findViewById("your resource id here")
           SharedPreference pref=PreferenceManager.getDefaultSharedPreference(getActivity());
    String text=pref.getString("example_text","")
    textView.setText(text);

     }