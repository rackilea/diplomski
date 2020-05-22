public class ImageTapView extends LinearLayout{
    public ImageTapView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }
      public ImageTapView(Context context){
        super(context);
        init(context);
    }
    private void init(Context context){
       LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         inflater.inflate(R.layout.your_xml, this, true);
    }
    public void onClick(){

    }    

}