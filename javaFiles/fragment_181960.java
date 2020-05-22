public class EmbeddedActivityParent extends ActivityGroup {

    private LinearLayout    mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.main);

         mRootLayout = (LinearLayout) findViewById(R.id.root_layout);

         // Add embedded status activity.
         embedActivity("StatusColumn", new Intent(this, StatusActivity.class));

         // Add embedded work activity.
         embedActivity("WorkArea", new Intent(this, MainActivity.class));
    }

    private void embedActivity(String myTag, Intent launchIntent) {
         final Window w = getLocalActivityManager().startActivity(myTag, launchIntent);
         final View wd = w != null ? w.getDecorView() : null;
         if (  null != wd ) {
             wd.setVisibility(View.VISIBLE);
             wd.setFocusableInTouchMode(true);

             mRootLayout.addView(wd);
         }
    }
}