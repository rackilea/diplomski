@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.activity_bottom_fragment, container, false);
    return root;
}

@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    BottomNavigationView navView =  root.findViewById(R.id.nav_view);

    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
        .build();

    NavController navController = Navigation.findNavController(activity, R.id.nav_host_fragment);//error here
    NavigationUI.setupActionBarWithNavController((AppCompatActivity) activity, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(navView, navController);
}