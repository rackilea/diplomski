private int editTextWidth, buttonWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ...

        // `transitions_container` is the parent of both `EditText` and `Button`
        // Thus, posting on it ensures that both of those views are laid out when this runnable is executed
        findViewById(R.id.transitions_container).post(new Runnable() {
            @Override
            public void run() {
                editTextWidth = mItemInputEditText.getWidth();
                // `mItemInputEditText` should be left visible from XML in order to get measured
                // setting to GONE after we have got actual width
                mItemInputEditText.setVisibility(View.GONE);
                buttonWidth = addButton.getWidth();
            }
        });
    }