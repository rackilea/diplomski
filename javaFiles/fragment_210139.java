mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.drawer_button, R.string.app_name, R.string.app_name)
    {
        @SuppressLint("NewApi")
        public void onDrawerSlide(View drawerView, float slideOffset)
        {
            float moveFactor;
                moveFactor = -(drawerView.getWidth() * slideOffset);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            {
               ((View)findViewById(R.id.frame_container)).setTranslationX(moveFactor);
            }
            else
            {
                TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                anim.setDuration(0);
                anim.setFillAfter(true);
                ((View)findViewById(R.id.content_frame)).startAnimation(anim);

            }
            lastTranslate = moveFactor;
        }

    };
    mDrawerLayout.setDrawerListener(mDrawerToggle);