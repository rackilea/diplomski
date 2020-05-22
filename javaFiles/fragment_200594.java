@Override
    public void onBackPressed() {
        saveData()
        super.onBackPressed();
    }

    private void saveData(){
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for(Fragment f : fragments){
            if(f != null && f instanceof BaseFragment)
                ((BaseFragment)f).onBackPressed();
        }
    }