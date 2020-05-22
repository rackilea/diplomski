public class soundPageOne extends Activity {

    private MediaPlayer[] mPlayers = new MediaPlayer[2];
    private int mNextPlayer = 0;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.soundsone);
        Button playSound1 = (Button)this.findViewById(R.id.peter1Button);
        playSound1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSound(R.raw.peter1);
            }
        });
    }

    public void onDestroy() {
        super.onDestroy(); // <---------------------- This needed to be there
        for (int i = 0; i < mPlayers.length; ++i)
            if (mPlayers[i] != null)
                try {
                    mPlayers[i].release();
                    mPlayers[i] = null;
                }
                catch (Exception ex) {
                    // handle...
                }
    }

    private void startSound(int id) {
        try {
            if (mPlayers[mNextPlayer] != null) {
                mPlayers[mNextPlayer].release();
                mPlayers[mNextPlayer] = null;
            }
            mPlayers[mNextPlayer] = MediaPlayer.create(this, id);
            mPlayers[mNextPlayer].start();
        }
        catch (Exception ex) {
            // handle
        }
        finally {
            ++mNextPlayer;
            mNextPlayer %= mPlayers.length;
        }
    }

}