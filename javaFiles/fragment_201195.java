final CategoryListActivity categoryFragment = new CategoryListActivity();
new GetAllCategoriesAsyncTask(
    new GetAllCategoriesAsyncTask.OnRoutineFinished() {
    public void onFinish() {
        if(mcallback != null){
            mcallback.callbackCall(getContext());
        }
        getFragmentManager().popBackStack();

            /*Bundle bundle = new Bundle();
            FragmentTransaction it = getFragmentManager().beginTransaction();

            bundle.putSerializable("categorylist", GetAllCategoriesAsyncTask.categoryList);
            categoryFragment.setArguments(bundle);
            it.replace(R.id.frame,categoryFragment);
            it.addToBackStack("tag");
            it.commit();*/

    }
}).execute();