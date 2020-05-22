class MyAdapter extends BaseAdapter {

    public interface IProcessFilter {
        void onProcessFilter(String string1, String string2)
    }

    private IProcessFilter mCallback;

    public MyAdapter(Context context, String string1, String string2, IProcessFilter callback) {
        mCallback = callback;
    }

    public View getView( final int position, View convertView, ViewGroup   parent)
    {
        holder.checkBox.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                mCallback.onProcessFilter("string1", "string2");
            }
        }
   }
}