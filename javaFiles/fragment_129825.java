@Override
                public void onPageSelected(int position) {
                    if(position == 0) {
                        ProfileFragment fragment = (ProfileFragment) getSupportFragmentManager().getFragments().get(1)
                        fragment.setActionBarTitle("Profil");
                    } else {
                        StartingTestFragment fragment2 = (StartingTestFragment) getSupportFragmentManager().getFragments().get(0);
                        fragment2.setActionBarTitle("Anasayfa");
                    }

                }