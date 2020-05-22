DatabaseAccess db=DatabaseAccess.getInstance(getApplicationContext());
db.open();
mycursor= db.getblindfirst(newid);
scursor= db.getblindlast(newid);
scursor.moveToFirst();
mycursor.moveToFirst();
a= mycursor.getInt(0);
b=scursor.getInt(0);
mPlayer = new MediaPlayer();
try {
    mPlayer.setDataSource("/mnt/sdcard/audio/aya(" + a + ").mp3");
    mPlayer.prepare();
} catch (Exception e) {
    e.printStackTrace();
}
mPlayer.start();
a++;
mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    public void onCompletion(MediaPlayer mp) {
        if (a!=b) {
            if(mPlayer != null) {
                if(mPlayer.isPlaying()) {
                    mPlayer.stop();
                }
                mPlayer.reset();
            }
            try {
                mPlayer.setDataSource("/mnt/sdcard/audio/aya(" + a + ").mp3");
                mPlayer.prepare();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mPlayer.start();
            a++;
        }
    }
});
db.close();
}