public class OtherProfile extends Profile {

public OtherProfile(Context context, AttributeSet attrs) {
    super(context, attrs);
}

@Override
protected void init() {
    findViewById(R.id.tvUser).setVisibility(View.GONE);
}