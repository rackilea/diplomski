class MyTextView extends TextView implements View.OnClickListener{

    public MyTextView(Context context) {
        super(context);
        this.setOnClickListener(this);
    }

    public static interface MyTextListener{
        public void updateUI();
    }

    @Override
    public void onClick(View v) {
        if(getContext() instanceof MyTextListener){
            ((MyTextListener)getContext()).updateUI();
        }
    }
}