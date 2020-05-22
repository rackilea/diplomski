import java.lang.reflect.Field;
    public class MainActivity extends Activity {

        private ViewPager mViewPager;
        MediaPlayer mp;
        private boolean isPaused;
        private ArrayList<Integer> mMp3s;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mViewPager = (ViewPager) findViewById(R.id.view_pager);
            ImageAdapter adapter = new ImageAdapter(this);
            mMp3s=getAllMp3FilesFromRaw();
            mViewPager.setAdapter(adapter);

            final GestureDetector tapGestureDetector = new GestureDetector(this, new TapGestureListener());
            mViewPager.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    tapGestureDetector.onTouchEvent(event);
                    return false;
                }
            });
        }

        private class TapGestureListener extends GestureDetector.SimpleOnGestureListener {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {

                    if (mp != null) {
                        if (isPaused) {
                            mp.start();
                            isPaused = false;
                        } else {
                            mp.pause();
                            isPaused = true;
                        }
                    } else {
                        mp = MediaPlayer.create(MainActivity.this, mMp3s.get(mViewPager.getCurrentItem()));
                        mp.start();
                        isPaused = false;
                    }


                //AND SO ON FOR 50 PAGES//
                mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        if (mp == null) {
                            return;
                        }
                        mp.release();
                        mp = null;
                        isPaused = true;
                    }

                    @Override
                    public void onPageScrollStateChanged(int arg0) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onPageScrolled(int arg0, float arg1, int arg2) {
                        // TODO Auto-generated method stub
                    }
                });

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer m) {
                        Toast.makeText(MainActivity.this, "COMPLETED", Toast.LENGTH_LONG).show();
                        // Set the MainActivity member to null
                        finish();
                        MainActivity.this.mp = null;
                    }
                });

                return super.onSingleTapConfirmed(e);
            }
        }

        /**
        *Do it on background thread if it blocks the UI.
        */
        private ArrayList<Integer> getAllMp3FilesFromRaw() {
            ArrayList<Integer> mp3s = new ArrayList<>();
            try {
                Field fields[] = R.raw.class.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Field f = fields[i];

                    int resIdentifier = getResources().getIdentifier(f.getName(), "raw", getPackageName());
                    mp3s.add(resIdentifier);
                }
                return mp3s;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }