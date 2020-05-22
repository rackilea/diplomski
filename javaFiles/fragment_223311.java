@Override
public void onBackPressed() 
{
    super.onBackPressed();
}

ivVoltar.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(findViewById(android.R.id.content)
                .getWindowToken(), 0);

            onBackPressed();
        }
    });