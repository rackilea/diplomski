viewPager=(ViewPager)findViewById(R.id.viewPager);

        FragmentManager fm=getSupportFragmentManager();

        viewPager.setAdapter(new MyAdapter(fm));


    }

    class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {



            if(position==0)
                fragment= new Home1();




            if(position==1)
                fragment=new Home2();
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}