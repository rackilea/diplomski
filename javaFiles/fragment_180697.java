public int getCount() {
    return soundcloudDates.length;
}

public Object getItem(int position) {
    return soundcloudDates[position];
}

public View getView(int position, View convertView, ViewGroup parent) {
    // Not using convertView for simplicity. You should probably use it
    // in real application to get better performance.
    ImageView imageView = new ImageView(context);
    String text = (String) getItem( position );
    int resId;
    switch (position) {
    case 0:
        resId = R.drawable.logo;
            break;
    case 1:
        resId = R.drawable.soundcloudtest;
            break;
    case 2:
        resId = R.drawable.logo;
            break;
    case 3:
        resId = R.drawable.ic_launcher;
            break;
    default:
        resId = R.drawable.ic_launcher;
    }
    dateView.setText(text);
    imageView.setImageResource(resId);
    return imageView;
}