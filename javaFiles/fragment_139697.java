@Override
public void onBindViewHolder( SingerListAdapter.SingerListViewHolder viewHolder, int i) {
    String drawableAddress = "gray_rectangle_" + i;
    viewHolder.singerName.setText(musicDataModel.get(i).getmAtrist());
    if (i != 47) {
        int idResource = context.getResources().getIdentifier(drawableAddress,"drawable",context.getPackageName());
        viewHolder.singerMusicCover.setImageResource(idResource);
    } else {
        viewHolder.singerMusicCover.setImageResource(R.drawable.gray_rectangle_5);
    }
}