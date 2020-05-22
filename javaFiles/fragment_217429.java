Fragment fr;

         if(view == findViewById(R.id.button2)) {
             fr = new FragmentTwo();

         }else {
             fr = new FragmentOne();
         }

         FragmentManager fm = getFragmentManager();
         FragmentTransaction fragmentTransaction = fm.beginTransaction();
         fragmentTransaction.replace(R.id.fragment_place, fr);
         fragmentTransaction.commit();