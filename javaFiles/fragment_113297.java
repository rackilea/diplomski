public class MyAdapter extends SimpleCursorAdapter {

    public MyAdapter(Context context, int layout, Cursor c, String[] from,
                           int[] to, int flags) {
       super(context, layout, c, from,to,flags);
    }

@Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view = super.getView(position, convertView, parent);
       //Here we are adding meta data which is position in our case
       view.findViewById(R.id.play_song).setTag(position);
       return view;
    }
}