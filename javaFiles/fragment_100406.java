public class LoaderActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Void> {
    private TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);

        Button startButton = findViewById(R.id.start_button);
        Button cancelButton = findViewById(R.id.cancel_button);
        counter = findViewById(R.id.counter);
        startButton.setOnClickListener((view) -> {
            getSupportLoaderManager().initLoader(0, null, LoaderActivity.this);
        });
        cancelButton.setOnClickListener((view) -> {
            // do nothing, apparently
        });

        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoaderProgressEvent(MyAsyncTaskLoader.ProgressEvent event) {
        counter.setText("" + event.getNumber());
    }

    @NonNull
    @Override
    public Loader<Void> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new MyAsyncTaskLoader(LoaderActivity.this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@NonNull Loader<Void> loader, Void aVoid) {
        counter.setText("Done!");
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Void> loader) {

    }

    public static class MyAsyncTaskLoader extends AsyncTaskLoader<Void> {
        public static class ProgressEvent {
            private final int number;

            public ProgressEvent(int number) {
                this.number = number;
            }

            public int getNumber() { return number; }
        }

        public MyAsyncTaskLoader(@NonNull Context context) {
            super(context);
        }

        @Nullable
        @Override
        public Void loadInBackground() {
            for (int i = 0; i<10;i++){
                EventBus.getDefault().post(new ProgressEvent(i));
                SystemClock.sleep(500);
            }
            return null;
        }
    }
}