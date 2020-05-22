myViewModel.getAllData().observe( this, new Observer<List<MyEntity>>() {
    @Override
    public void onChanged(@Nullable List<MyEntity> myEntities) {
        Log.d("TAG: ", "DATA CHANGED! " + myEntities.toString());
    }
});