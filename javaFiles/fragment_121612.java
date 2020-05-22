public class test extends Activity implements Drawable.Callback {

 public TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        tv = (TextView) findViewById(R.id.testtext);
        new LoadImage().execute("http://lonelytraveller.comoj.com/qff/tjatja.gif");

    }

    @Override
    public void invalidateDrawable(Drawable who) {
        tv.invalidate();
    }

    @Override
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        tv.postDelayed(what, when);
    }

    @Override
    public void unscheduleDrawable(Drawable who, Runnable what) {
        tv.removeCallbacks(what);
    }


    class LoadImage extends AsyncTask<Object, Void, byte[]> {

        private String key;
        @Override
        protected byte[] doInBackground(Object... params) {
            String source = (String) params[0];
            //key = source.split("\\Q/\\E")[source.split("\\Q/\\E").length-1];
            try {
                InputStream is = new URL(source).openStream();
                return IOUtils.toByteArray(is);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(byte[] b) {
            SpannableStringBuilder ssb = new SpannableStringBuilder("test");
            GifDrawable gd = null;
            try {
                gd = new GifDrawable(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (gd != null) {
                gd.setBounds(0, 0, gd.getIntrinsicWidth(), gd.getIntrinsicHeight());

                gd.setCallback(test.this);

                ssb.setSpan(new ImageSpan(gd), 1, 2, 0);
                tv.setText(ssb);
            }
        }
    }
}