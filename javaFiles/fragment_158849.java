if(viewPager != null){

    if(adapter != null){
        Fragment fragment = adapter.getItem(2);
        if(fragment != null){
            RequestFragment requestFragment = (RequestFragment) fragment;
            requestFragment.setRecyclerView();
        }
    }
}