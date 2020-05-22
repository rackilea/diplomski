public class ButtonInternetAccess extends UIButton implements OnClickListener {
        String url;
    Context mContext;
    public ButtonInternetAccess(Context context, AttributeSet attrs,String url) {
            super(context, attrs);
         this.url = url;
        this.mContext=mContext;
            // TODO Auto-generated constructor stub
        }
        // initialize button and add click listener here.