case 3:
    emailView.findViewById(R.id.emailView);
    Class ourClass = Class.forName("com.packagename.Email");
    try
    {
        //change this
        //Intent ourIntent = new Intent(Tabs.this, ourClass);
        //to
        Intent ourIntent = new Intent(getActivity(), ourClass);
        getActivity().startActivity(ourIntent);
    }
    catch(ClassNotFoundException e)
    {
         e.printStackTrace();
    }
    return emailView;