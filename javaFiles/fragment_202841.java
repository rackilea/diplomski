public class ButtonWithID extends Button {

    public final int id;

    public MyExtendedView(Context context){
        this(context, null);
    }

    public MyExtendedView(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public MyExtendedView(Context context, AttributeSet attrs, int defaultStyle){
        super(context, attrs, defaultStyle);
        this.id = this.getId();
    }