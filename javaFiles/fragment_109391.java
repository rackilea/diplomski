public class QuestionPaper extends Fragment {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = HomeFragment.newInstance();
                    createFragment(homeFragment);
                    return true;
                case R.id.navigation_dashboard:
                    DashBoardFragment dashBoardFragment = DashBoardFragment.newInstance();
                    createFragment(dashBoardFragment);
                    return true;
                case R.id.navigation_notifications:
                    NotiFragment notiFragment = NotiFragment.newInstance();
                    createFragment(notiFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_paper, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextMessage = (TextView) view.findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void createFragment(Fragment fragment) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(R.id.activity_home_container, fragment, null);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }
}