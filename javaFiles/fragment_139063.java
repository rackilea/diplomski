public class MusicPlayer extends AsyncTask<Void, Void, Void>
{
    public String filename;
    public boolean backgroundMusicPlaying;
    public ??? backgroundMusic;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //this method will be running on UI thread
    }
    @Override
    protected Void doInBackground(Void... params) {
        //this method will be running on background thread so don't update UI frome here
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        //this method will be running on UI thread
    }


    public void playMusic() {
        // stub
    }

    public void pauseMusic() {
        // stub
    }

    public void setVolume(float level) {
        // stub
    }

    // etc
}