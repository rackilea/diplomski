private void showDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
        mDialog = new AlertDialog.Builder....
    }

private void hideDialog(){
       if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
            }
}