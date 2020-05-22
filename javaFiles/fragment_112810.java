public class SimpleCardView extends LinearLayout {
    protected SimpleCard card = null;
    protected TextView textView;

    public SimpleCardView(Context context) {
        super(context);     
    }

    public SimpleCardView(Context context, AttributeSet attrs) {
        super(context, attrs);      
    }

    public SimpleCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init(getContext());
    }

    protected void init(Context context) {
        textView = (TextView)findViewById(R.id.simple_label);
    }

    public void setCard(SimpleCard card) {
        this.card = card;
        textView.setText(card.getMessage());        
    }
}