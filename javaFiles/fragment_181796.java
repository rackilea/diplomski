public class ViewMenuButton extends View{

    private TextView tvText;
    private ImageView ivImage;

    public ViewMenuButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);        
        init();
    }
    public ViewMenuButton(Context context, AttributeSet attrs) {
        super(context, attrs);      
        init();
    }
    public ViewMenuButton(Context context) {
        super(context);
        init();
    }


    private void init() {           
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //here you can inflate a own XML for that View
        inflater.inflate(R.layout.view_menubutton, this, true);  
        this.tvText= (TextView)this.findViewById(R.id.tvText);      
        this.ivImage = (ImageView)this.findViewById(R.id.ivImage);

    }

    public void setText(String text){
        if(this.tvText != null){
            tvText.setText(text);
        }
    }

    //... and so on

}