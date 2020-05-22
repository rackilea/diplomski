public class StartPage extends Activity {
    boolean menuOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        //Handlers
        RelativeLayout menuContainer = (RelativeLayout) findViewById(R.id.MenuContainer);
        ImageView menuButton = (ImageView) findViewById(R.id.temp_menu);
        //Make sure the menu is not displaying
        menuContainer.setVisibility(View.GONE);

        menuButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!StartPage.this.menuOpen) {
                    StartPage.this.menuOpen = true;
                    RelativeLayout menuContainer = (RelativeLayout) findViewById(R.id.MenuContainer);
                    menuContainer.setVisibility(View.VISIBLE);
                } else {
                    StartPage.this.menuOpen = false;
                    RelativeLayout menuContainer = (RelativeLayout) findViewById(R.id.MenuContainer);
                    menuContainer.setVisibility(View.GONE);
                }
            }
        });

    }
}