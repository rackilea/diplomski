public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

private SwipeRefreshLayout swipeRefreshLayout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        //to change the color of the refresh indictor
        swipeRefreshLayout.setColorScheme(getResources().getColor(R.color.yourcolor), 
                getResources().getColor(R.color.yourcolor), 
                getResources().getColor(R.color.yourcolor), 
                getResources().getColor(R.color.yourcolor));
    }

    @Override
    public void onRefresh() {
    //do something here
    //setRefreshing(false) will hide the indicator
    swipeRefreshLayout.setRefreshing(false);
    }
}