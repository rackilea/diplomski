@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ImageTapView view = (ImageTapView ) convertView;
    if (view == null)
        view = new ImageTapView (getContext());

    return view;
}