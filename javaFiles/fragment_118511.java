public RelativeLayout createViewTOAdd(){
    lp=new RelativeLayout.LayoutParams(android.widget.RelativeLayout.LayoutParams.FILL_PARENT,android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT);
    RelativeLayout mRelativeLayout=new RelativeLayout(this);
    mRelativeLayout.setBackgroundColor(Color.WHITE);
    TextView mTextView=new TextView(this);
     RelativeLayout.LayoutParams Textview_lp=new RelativeLayout.LayoutParams(android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT,android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT);
    mTextView.setText("Amout");
    Textview_lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
    Textview_lp.addRule(RelativeLayout.CENTER_VERTICAL);
    Textview_lp.leftMargin=10;
    mTextView.setTextColor(Color.BLACK);
    mTextView.setTextAppearance(this, R.style.TextStyle);
    //mTextView.setLayoutParams(Textview_lp);
    EditText mEditText=new EditText(this);
     RelativeLayout.LayoutParams EditText_param=new RelativeLayout.LayoutParams(android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT,android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT);
     EditText_param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
     EditText_param.addRule(RelativeLayout.CENTER_VERTICAL);
     EditText_param.rightMargin=10;
    //mEditText.setLayoutParams(EditText_param);
    //mRelativeLayout.addView(mTextView, 0);
    //mRelativeLayout.addView(mEditText, 1);
    //mRelativeLayout.addView(mTextView);
    //mRelativeLayout.addView(mEditText);
    mRelativeLayout.addView(mTextView, Textview_lp);
    mRelativeLayout.addView(mEditText, EditText_param);
    return mRelativeLayout;
}