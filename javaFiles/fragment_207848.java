@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
   Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);

}