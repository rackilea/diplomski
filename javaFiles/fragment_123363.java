YourFragment fragment=new YourFragment();
            Bundle bundle = new Bundle();  
            bundle.putParcelableArrayList("arraylist", cauHoiArrayList);
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment,"myfrag");
            fragmentTransaction.commit();