@Override
      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    try {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE  && resultCode  == RESULT_OK) {

            String requiredValue = data.getStringExtra(DisplayWord.EXTRA_KEY);
        }
    } catch (Exception ex) {
        Toast.makeText(Activity.this, ex.toString(),
                Toast.LENGTH_SHORT).show();
    }

}