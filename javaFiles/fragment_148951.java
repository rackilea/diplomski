settingsButton = (ImageButton) findViewById(R.id.settingsButton);
    settingsButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
             // get Current Item from ViewPager
            int currentpage=mPager.getCurrentItem();
            switch(currentpage){

             case 0:
             mPager.setCurrentItem(1, true);
             break;
             case 1:
             mPager.setCurrentItem(0, true); 
             break;
            }
        }
    });