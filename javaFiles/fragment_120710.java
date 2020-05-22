class myAdapter <A extends DataTypaA<C>, 
                 B extends SparseArray<? extends DataTypeB, 
                                       ? extends DataTypeC>, 
                 C extends DataTypeC> 
    extends FragmentStatePagerAdapter {

    A myFragment;
    SparseArray<B, C> data;
    C items;

    public myAdapter(FragmentManager fm, A fragment) {
        data = new SparseArray<B, C>();
        myFragment = fragment;
        items =  myFragment.getData();
    }

    public B getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return items.getList().size();
    }   

    public void setData () {
        items = myFragment.getItems ();  //getItems return DataTypeC
        data.setTheData(items);
    }
}