public void addItem(final ArrayList<String> list,int h) {

    final int oldsize = items.size();
    for (int i=list.size()-1; i>=0 ;i--){
        items.add(0,list.get(i));
    }

    activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
            notifyItemRangeInserted(0,items.size()-oldsize);
        }
    });

}