private void init(AttributeSet attrs, Context context){
    // do your other View related stuff here //


    TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);
    int xmlProvidedText1Size = a.int(R.styleable.MyCustomView_text1Size);
    int xmlProvidedText2Size = a.int(R.styleable.MyCustomView_text2Size);

    myTextView1.setTextSize(xmlProvidedText1Size);
    myTextView2.setTextSize(xmlProvidedText2Size);

    // and other stuff here //
}