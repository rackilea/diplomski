public class WebViewActivity extends AppCompactActivity {

            public static final String INTENT_MENUTYPE = "intent_menu_type";

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
    /* webview layout with <Framelayout> as a child having id =container
       that gets replaced by a fragment at run time.
           [make your own layout here] 
    */
                setContentView(R.layout.activity_webview);
                Bundle bundle = getIntent().getExtras();
                if (bundle != null && bundle.containsKey(INTENT_MENUTYPE)) {
                    MenuType menuType = (MenuType) bundle.getSerializable(INTENT_MENUTYPE);
                    openFragment(WebViewFragment.newInstance(menuType));
                }
            }


        public void openFragment(Fragment fragment) {
                FragmentTransaction ft = getSupportFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.container,
                        fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commitAllowingStateLoss();
            }
        }