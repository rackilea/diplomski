ViewPager viewPager = null; 
MyAdapter adapter = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewPager = (ViewPager)findViewById(R.id.pager);    
    myAdapter = new MyAdapter(getSupportFragmentManager());
    viewPager.setAdapter(myAdapter);
}


public String sum(){
    return Integer.toString(((FragA)myAdapter.getItem(0)).getInt() + ((FragB)myAdapter.getItem(1)).getInt());
}

public class MyAdapter extends FragmentStatePagerAdapter {  
    public MyAdapter (FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;

        if (i == 0)
        {
            fragment = new FragA();
        }
        if (i == 1)
        {
            fragment = new FragB();
        }
        if (i == 2)
        {
            fragment = new FragC(); 
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }   
}