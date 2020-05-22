EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mEditText = (EditText)findViewById(R.id.edit);  // Initialzation of Edittext
        mEditText.setSelection(mEditText.getText().length()); // After initialization keep cursor on right side
        mEditText.setCursorVisible(false);  // Disable the cursor.

        /*
        Add Click listener and on put your code that will keep cursor on right side
         */
        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setSelection(mEditText.getText().length());
            }
        });
}