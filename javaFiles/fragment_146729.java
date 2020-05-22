@Override
public Object instantiateItem (ViewGroup container, int position) {
    TextView tv = new TextView(getContext());
    tv.setText(mList.get(position));
    return tv;
}