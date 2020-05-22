mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override

        public void onPageSelected(int position) {
            switch(position) {
                case 1: if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {                
                      getWindow().setNavigationBarColor(Color.parseColor(BLUE));
                    }
                    break;    
                case 2: if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {                
                      getWindow().setNavigationBarColor(Color.parseColor(RED));
                    }
                    break;    
                case 3: if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {                
                      getWindow().setNavigationBarColor(Color.parseColor(GREEN));
                    }
                    break;    
            }
        }

        @Override
        public void onPageScrolled(int position, float offset, int offsetPixel) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    });