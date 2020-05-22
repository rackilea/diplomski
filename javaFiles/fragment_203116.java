public View getView(int position, View convertView, ViewGroup parent) {
    ImageView imageView = new ImageView(mContext);
    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    imageView.setAdjustViewBounds(true);
    imageView.setImageResource(getItem(position));
    return imageView;
}