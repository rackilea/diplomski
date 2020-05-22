View rootView
@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

     rootView = inflater.inflate(R.layout.profile_tab, container, false);


     displayData();



    return rootView;
    }


public void displayData(){

    DatabaseHelper db = new DatabaseHelper(getActivity());
    db.createUser(new User("Emma","Team", "School"));
    db.createUser(new User("Sarah","team", "School"));
    username = db.getUserFromTable(userIDTest);
    displayName= (TextView) rootView.findViewById(R.id.TextViewTest);
    displayName.setText(username.getUserName());
}