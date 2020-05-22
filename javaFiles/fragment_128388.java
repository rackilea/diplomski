@Override
public View getView(int position, View convertView, ViewGroup parent) {
     CoverHolder holder = null;
     if (convertView == null) {
         convertView = mInflater.inflate(R.layout.album_layout, null);
         holder = new CoverHolder();
         holder.coverView = (ImageView)convertView.findViewById(R.id.song_cover);
         convertView.setTag(holder);
     } else {
         holder = (CoverHolder)convertView.getTag();
     }
    Glide.with(mContext).load(currSong.getCover()).override(50,50).into(holder.coverView);
    return convertView;
}

// The holder
public static class CoverHolder{
    public ImageView coverView;
}