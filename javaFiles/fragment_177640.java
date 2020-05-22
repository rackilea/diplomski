public class MyCustomImageView extends ImageView{

    public MyCustomImageView(Context context){
        super(context);
        setOnClickListener(theCommonListener);
    }

    private OnClickListener theCommonListener = new OnClickListener(){
        public void onClick(View v) {
             // do what you want here
        }
    }
}