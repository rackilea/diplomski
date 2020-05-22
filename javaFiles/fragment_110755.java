public abstract class Profile extends RelativeLayout {

public Profile(Context context, AttributeSet attrs) {
    super(context, attrs);
    initImpl();
}

final private void initImpl() {
    ((LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_profile, this, true);
    init();
}

protected abstract void init();