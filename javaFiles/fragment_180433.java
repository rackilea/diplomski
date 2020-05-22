public class MainActivity extends ActionBarActivity {

DrawerLayout mDrawerLayout;
ListView mDrawerList;
ActionBarDrawerToggle mDrawerToggle;
String[] mDrawerListItems;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);

    Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);

    mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
    mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.primaryDark));

    mDrawerListItems = getResources().getStringArray(R.array.drawer_list);

    mDrawerList = (ListView)findViewById(android.R.id.list);
    mDrawerList.setAdapter(new ArrayAdapter<>
            (this, android.R.layout.simple_list_item_1, mDrawerListItems));
    mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            openFragment(position);
        }
    });
    mDrawerToggle = new ActionBarDrawerToggle(this,
            mDrawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close){
        public void onDrawerClosed(View v){
            super.onDrawerClosed(v);
            invalidateOptionsMenu();
            syncState();
        }
        public void onDrawerOpened(View v){
            super.onDrawerOpened(v);
            invalidateOptionsMenu();
            syncState();
        }
    };

    mDrawerLayout.setDrawerListener(mDrawerToggle);
    mDrawerToggle.syncState();
}

protected void openFragment(int position){

    Intent intent;
    switch (position) {
        case 0:
            intent = new Intent(this, Activity1.class);
            break;
        case 1:
            intent = new Intent(this, Activity2.class);
            break;
        case 2:
            intent = new Intent(this, Activity3.class);
            break;
        case 3:
            intent = new Intent(this, Activity4.class);
            break;
        default:
            intent = null;
    }
    startActivity(intent);
    //mDrawerLayout.closeDrawer(mDrawerList);    

}

@Override
protected void onPostCreate(Bundle savedInstanceState){
    super.onPostCreate(savedInstanceState);
    mDrawerToggle.syncState();
}

@Override
public void onConfigurationChanged(Configuration newConfig){
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
}

@Override
public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()){
        case android.R.id.home: {
            if (mDrawerLayout.isDrawerOpen(mDrawerList)){
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
            return true;
        }
        default: return super.onOptionsItemSelected(item);
    }
}