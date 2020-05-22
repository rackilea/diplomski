@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin_);

    storage=FirebaseStorage.getInstance();
    storageReference=storage.getReference();

    //your codes continues...

   NavigationView navigationView =(NavigationView)getActivity().findViewById(R.id.nav_view);
   View parentView = navigationView.getHeaderView(0);
   ImageView navProfilePic = parentView.findViewById(R.id.admin_nav_imageView);

   DrawerLayout mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);                    

    NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
    final View parentView = navigationView.getHeaderView(0);
    final ImageView navProfilePic = parentView.findViewById(R.id.img_header_bg);

    DrawerLayout mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

    mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {
            Picasso.get()
                       .load(globalDeclaredUri)
                       .resize(250,250)
                       .into(navProfilePic);
        }
    });
}