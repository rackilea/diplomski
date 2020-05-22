@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {

    super.onActivityResult(requestCode, resultCode, data);

    try {
        Session.getActiveSession().onActivityResult(this, requestCode,
                resultCode, data);
    } catch (Exception e) {
        // do nothing
    }
}