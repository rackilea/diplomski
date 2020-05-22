public class InviteActivity extends MainActivity {

public static void openActivity(Activity from_activity) {
    Intent intent = new Intent(from_activity, InviteActivity.class);

    Bundle bundle = new Bundle();
    bundle.putInt(MainActivity.KEY_LAYOUT_ID, R.layout.invite_activity);
    bundle.putBoolean(MainActivity.KEY_HAS_LEFT_DRAWER, true);
    bundle.putBoolean(MainActivity.KEY_HAS_RIGHT_DRAWER, false);

    intent.putExtra(MainActivity.KEY_MAIN_BUNDLE, bundle);
    from_activity.startActivity(intent);
}

@Override
protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      .....

    }