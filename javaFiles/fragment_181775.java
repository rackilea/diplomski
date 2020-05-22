private boolean activityRecreated;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityRecreated = savedInstanceState != null;
}

@Override
public void onStart() {
    if (activityRecreated) {
       // code here
    }
}