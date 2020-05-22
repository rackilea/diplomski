// A list to keep reference to your created edit texts
List<EditText> mEditTexts = new ArrayList<EditText>();

// Get root view of your activity
ViewGroup viewGroup = (ViewGroup) ((ViewGroup) 
            findViewById(android.R.id.content)).getChildAt(0);

// Get the button and set a click listener to it
Button mButton = (Button) findViewById(R.id.button_id);
mButton.setOnClickListener(new OnClickListener(){

    @Override
    public void onClick(View v){
        // Build edit text
        EditText mEditText = new EditText(v.getContext());

        // Pass two args (arg1/arg2); must be LayoutParams.MATCH_PARENT, 
        // LayoutParams.WRAP_CONTENT, or an integer pixel value.
        mEditText.setLayoutParams(new LayoutParams(arg1, arg2));

        // Add the edit text to your list
        mEditTexts.add(mEditText);

        // Add edit text to your root view
        viewGroup.addView(mEditText);
    }
}