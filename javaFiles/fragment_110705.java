private boolean doubleBackToExitPressedOnce = false;

@Override
protected void onResume() {
    super.onResume();
    // .... other stuff in my onResume ....
    this.doubleBackToExitPressedOnce = false;
}

@Override
public void onBackPressed() {
    if (doubleBackToExitPressedOnce) {
        super.onBackPressed();
        return;
    }
    this.doubleBackToExitPressedOnce = true;
    Toast.makeText(this, "Press twice to exit", Toast.LENGTH_SHORT).show();

}