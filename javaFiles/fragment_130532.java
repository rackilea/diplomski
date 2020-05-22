private final SongListListener mListener;

public SongListDialog(SongListListener listener, ...) {
    mListener = listener;
}


@OnClick(R.id.card_view)
void onClick() {
     Song song = songs.get(getAdapterPosition());
     dialog.dismiss();

    // notify listener
    mListener.PlaySong(song);
}