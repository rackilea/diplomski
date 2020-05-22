public class HeaderListViewFromXML extends ListView {
    private int headerId;

    public HeaderListViewFromXML(Context context) {
        this(context, null);
    }

    public HeaderListViewFromXML(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderListViewFromXML(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.HeaderListViewFromXML, defStyle, defStyle);

        try {
            headerId = a.getResourceId(R.styleable.HeaderListViewFromXML_headerView, View.NO_ID);
            if (headerId != View.NO_ID) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View header = inflater.inflate(headerId, null);
                addHeaderView(header);
            }
        } finally {
            a.recycle();
        }
    }
}