@Override
public void onBackPressed() {
    editor.putString("present", etPresent.getText().toString());
    editor.putString("details", etDetails.getText().toString());
    editor.putString("benefit", etBenefit.getText().toString());
    editor.apply();     
    super.onBackPressed();
}