@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) 
{
        View view = inflater.inflate(R.layout.fragment_nav_menu, null);
        mDrawerLayout = view.findViewById(R.id.drawerLayout);
         ..................................
        navigationView = view.findViewById(R.id.nav_view);

        return view;
}