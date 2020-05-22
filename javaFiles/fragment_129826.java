@Override
        public void onPageSelected(int position) {
            Fragment fragment1 = getActivity().getSupportFragmentManager().getFragments().get(position);
                if(fragment1 instanceof ProfileFragment) {
                    ProfileFragment fragment = (ProfileFragment) fragment1;
                    fragment.setActionBarTitle("Profil" );
                }
                else{
                    StartingTestFragment fragment = (StartingTestFragment) fragment1;
                    fragment.setActionBarTitle("Anasayfa");
                }
            } 

        }