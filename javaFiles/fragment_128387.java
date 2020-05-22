@Override
public View getView(int position, View convertView, ViewGroup parent) {

    RelativeLayout albumsLay = (RelativeLayout)songInf.inflate
            (R.layout.album_layout, parent, false);
    ImageView coverView = (ImageView)albumsLay.findViewById(R.id.song_cover);

    //get song using position
    Song currSong = songs.get(position);

    // If you are sure currSong.getCover() exists you can remove the if statement
    if(new File(currSong.getCover().exists))
        Glide.with(mContext).load(currSong.getCover()).override(50,50).into(coverView);


    albumsLay.setTag(position);
    return albumsLay;
}