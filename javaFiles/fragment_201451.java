public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    //your arraylist here
    MyAdapter myadp=new MyAdpater(arraylilst);
     listview.setAdapter(myadp);
        myadp.notifyDataSetChanged();
    return super.onCreateView(inflater, container, savedInstanceState);
      }