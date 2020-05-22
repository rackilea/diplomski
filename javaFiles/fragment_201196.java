Bundle bundle = new Bundle();
EditCategoryActivity editFragment = new EditCategoryActivity();
FragmentTransaction et = getFragmentManager().beginTransaction();
editFragment.setCategoryListCallBack(this);
        bundle.putSerializable("category", model);
        editFragment.setArguments(bundle);
        et.replace(R.id.frame,editFragment);
        et.addToBackStack("tag");
        et.commit();