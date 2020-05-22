class MyFrameLayout extends FrameLayout
{
    MyFrameLayout(Context context){
        super(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        Log.v("measure", "width:" + w + " height:" + h);
        if(w != h) {
            this.setLayoutParams(new TableRow.LayoutParams(
                    w, w
            ));

        }
    }
}