public class MPagerAdapter extends PagerAdapter {

private Context mContext;
private List<String> songs = new ArrayList<String>();

public MPagerAdapter(Context context , List<String> songs) {
    mContext = context;
    this.songs = songs;
}

@Override
@NonNull
public Object instantiateItem(@NonNull final ViewGroup collection, final int position) {
    LayoutInflater inflater = LayoutInflater.from(mContext);
    View layout = (View) inflater.inflate(R.layout.layout_list, collection, false);

    TextView tv = (TextView) layout.findViewById(R.id.tv_song);
    tv.setText(songs.get(position));
    Button b = (Button) layout.findViewById(R.id.b_song);
    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext , "Play " + songs.get(position) , Toast.LENGTH_LONG).show();
        }
    });
    collection.addView(layout);
    return layout;
}

@Override
public void destroyItem(ViewGroup collection, int position, Object view) {
    collection.removeView((View) view);
}

@Override
public int getCount() {
    return songs.size();
}

@Override
public boolean isViewFromObject(View view, Object object) {
    return view == object;
}

@Override
public CharSequence getPageTitle(int position) {
    return songs.get(position);
}

}