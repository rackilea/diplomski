public void showFragment(Fragment fragment, String back_stack_name, boolean save_back) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        if(save_back) {
            transaction.addToBackStack(back_stack_name);
        }
        transaction.commit();
    }