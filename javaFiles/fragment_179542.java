public class UserActivity extends AppCompatActivity {
    private int cartindex = 0;
    private TextView counterTV = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                Intent intent = getIntent();
                Integer deletecounter = intent.getIntExtra("DeleteCounter",0);
                if (deletecounter>0) {
                    cartindex=Integer.parseInt(counterTV.getText().toString())-deletecounter;
                    invalidateOptionsMenu();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user, menu);
        final View menu_list = menu.findItem(R.id.action_hawk).getActionView();
        counterTV = (TextView) menu_list.findViewById(R.id.cartcounter);
        UpdateCartCount(cartindex);
        new MyMenuItemStuffListener(menu_hotlist, "Show message") {
            @Override
            public void onClick(View v) {
                Intent intent= new  Intent(UserActivity.this,CartActivity.class);
                intent.putExtra("ProductTitle",pname);
                intent.putExtra("ProductUrl",purl);
                intent.putExtra("ProductPrice",pprice);
                intent.putExtra("BargainPrice",bargainprice);
                UserActivity.this.startActivity(intent);
            }
        };
        return true;
    }

    //Function to update cart count
    public void UpdateCartCount(final int new_number) {
        cartindex = new_number;
        if (counterTV == null) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (new_number == 0)
                    counterTV.setVisibility(View.INVISIBLE);
                else {
                    counterTV.setVisibility(View.VISIBLE);
                    counterTV.setText(Integer.toString(new_number));
                }
            }
        });
    }

    @Override
    protected void onRestart() {
        if (CartActivity.cart.size()!=0) {
            cartindex=CartActivity.cart.size(); 
            invalidateOptionsMenu();
            super.onRestart()
        }