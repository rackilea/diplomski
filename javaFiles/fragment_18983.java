public class ImageAdapter extends BaseAdapter {

    static class ViewHolder {
        ImageView image;
        TextView text;

        ViewHolder(View v) {
            image = v.findViewById(R.id.image);
            text = v.findViewById(R.id.text);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String url = getItem(position);

        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.loader)
                .fit()
                .into(viewHolder.image);
        viewHolder.text.setText("my text");
        return imageView;
    }
}