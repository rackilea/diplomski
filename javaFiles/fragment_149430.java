private static void updateMediaplayerViews(View[] views, int type)
{
switch(type) {
    case 0:
        System.out.println("that?");
        ((TextView)views[0]).setText(mediaPlayer.getCurrentSongInfo().getName().length() > 22? mediaPlayer.getCurrentSongInfo().getName().substring(0, 19)+"..." : mediaPlayer.getCurrentSongInfo().getName());
        break;
}
views[views.length - 1].invalidate();
}