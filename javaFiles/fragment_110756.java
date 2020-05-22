public class UserProfile extends Profile {

public UserProfile(Context context, AttributeSet attrs) {
    super(context, attrs);
}

@Override
protected void init() {
    findViewById(R.id.tvOther).setVisibility(View.GONE);
}