@Override
    public void buttonClicked(View v) {
        // TODO Auto-generated method stub
        Fragment newFragment;

        // Create new fragment
        if(v.getId()==R.id.displayfragment1){
            newFragment = new MyFragment();
        }

        else{
            newFragment = new MyFragment2();
        }

        FragmentTransaction transaction=fragmentManager.beginTransaction();


        transaction.replace(R.id.myfragment, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }};