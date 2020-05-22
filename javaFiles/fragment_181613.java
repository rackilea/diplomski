//Set the pager with an adapter
 ViewPager pager = (ViewPager)findViewById(R.id.pager);
 pager.setAdapter(new TestAdapter(getSupportFragmentManager()));

 //Bind the title indicator to the adapter
 TitlePageIndicator titleIndicator = (TitlePageIndicator)findViewById(R.id.titles);
 titleIndicator.setViewPager(pager);