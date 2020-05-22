pager.setOnPageChangeListener(new OnPageChangeListener() {

                @Override
                public void onPageSelected(int arg0) {
                    // Now here you get your fragment object. 
                   // To get the Fragment Object you need to store them in an ArrayList in your FragPagerAdapter class.
                  //  create a method `getMyFraggment ` which return your Fragment from Arraylist.
                 //   Now create a method in your each Fragment which return your EditText values. Here you can use HashMap to store the values.

                // Here you use switch cases to get your Fragment Object I just wrote 1 here                        
                MyFragment f =  ((FragPagerAdapter)pager.getAdapter()).getMyFraggment(arg0);

                HashMap <String, String> hashMap = f.getValuesFromFragment();
                myValues.putAll(hashMap);    // myValues is global hashmap in your Activity. 
               // Now you get All values in your Global HashMap. But remember here you can get duplicate values if user swipe a fragment more than 1 time. You should do a logic here to remove duplicate values.

                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onPageScrollStateChanged(int arg0) {
                    // TODO Auto-generated method stub

                }
            });