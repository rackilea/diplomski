static class ViewHolder {

    private TextView friendsname;
    private ImageView thumb_image;
    private CheckBox cb;

}
public View getView(final int position, View convertView, ViewGroup parent) {

    ViewHolder mViewHolder = null;
    HashMap<String, String> song = null;

    if (convertView == null) {

        song = new HashMap <String, String>();
        mViewHolder = new ViewHolder();

        LayoutInflater vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = vi.inflate(R.layout.activity_friend_list_row, parent, false);
        mViewHolder.friendsname = (TextView) convertView.findViewById(R.id.friendsName); // title
        mViewHolder.thumb_image = (ImageView) convertView.findViewById(R.id.list_image); // thumb image


        mViewHolder.cb = (CheckBox) convertView.findViewById(R.id.checkBox);

        convertView.setTag(mViewHolder);
        mViewHolder.cb.setTag(data.get(position));

        mViewHolder.cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean ischecked) {

                InviteFriends.isChecked[position] = buttonView.isChecked();

            }
        });

    } else {

        mViewHolder = (ViewHolder) convertView.getTag();

    }

    song = mViewHolder.cb.getTag();

    mViewHolder.friendsname.setText(song.get(InviteFriends.KEY_DISPLAY_NAME));
    mViewHolder.imageLoader.DisplayImage(song.get(InviteFriends.KEY_IMAGEPROFILE_URL), thumb_image);
    mViewHolder.cb.setChecked(InviteFriends.isChecked[position]);

    return convertView;
}