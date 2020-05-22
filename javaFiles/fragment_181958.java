final Window w = getLocalActivityManager().startActivity(myTag, myIntent);
final View wd = w != null ? w.getDecorView() : null;
if (  null != wd ) {
    wd.setVisibility(View.VISIBLE);
    wd.setFocusableInTouchMode(true);
}
// TODO: Attach wd to a ViewGroup.