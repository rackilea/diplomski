private static final String TAGS_KEY = "tags";
......
@Override
public void onCreate(final Bundle bundle) {
    super.onCreate(bundle);

    // Reading runner params
    String tags = BuildConfig.TAGS;
    if (!tags.isEmpty()) {
        bundle.putString(TAGS_KEY, tags);
    }

    instrumentationCore.create(bundle);
    start();
}