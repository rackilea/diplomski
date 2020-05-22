public class MainActivity extends ActionBarActivity {

    private static final int RECORDER_SAMPLERATE = 44100;
    private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
    private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;
    private static final int BUFFSIZE = AudioRecord.getMinBufferSize(RECORDER_SAMPLERATE, RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING);
    private AudioRecord recorder = null;
    private SurfaceView mySurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySurface = (SurfaceView) findViewById(R.id.surfaceView);
        recorder = new AudioRecord(MediaRecorder.AudioSource.MIC, RECORDER_SAMPLERATE, RECORDER_CHANNELS, RECORDER_AUDIO_ENCODING, BUFFSIZE);
        recorder.startRecording();
    }

    private void respondToMIC() {
        new AudioRecordTask().execute();
    }

    private class AudioRecordTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            Canvas myCanvas;
            Paint paint = new Paint();
            paint.setARGB(255, 255, 100, 100);

            short sData[] = new short[BUFFSIZE / 2];

            // Run while the Activity is not finished.
            while (!isFinishing()) {
                int read = recorder.read(sData, 0, BUFFSIZE / 2);
                int min = 0;
                int max = 0;
                for (int j = 0; j < read; j++) {
                    if (sData[j] < min) min = sData[j];
                    if (sData[j] > max) max = sData[j];
                }
                myCanvas = mySurface.getHolder().lockCanvas();
                myCanvas.drawColor(Color.WHITE);
                myCanvas.drawCircle(myCanvas.getWidth() / 2, myCanvas.getHeight() / 2, ((myCanvas.getHeight() / 2) * Math.abs(max - min) / 65000), paint);
                mySurface.getHolder().unlockCanvasAndPost(myCanvas);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}