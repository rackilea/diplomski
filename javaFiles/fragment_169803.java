setContentView(your.layout.with.frameLayout);
    mViewPager = (HackyViewPager) findViewById(R.id.view_pager);
    mButton = (Button) findViewById(R.id.button);
    mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
               wallpaper.setResource(sDrawables[mViewPager.getCurrentItem()]);                  
            }
        });
    }