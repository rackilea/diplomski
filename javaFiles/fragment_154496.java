if (TextUtils.isEmpty(passwordSave.getText().toString().trim())) {
        Snackbar snackbar = Snackbar
                .make(view, "Please fill in your password", Snackbar.LENGTH_LONG)
                .setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

        snackbar.setActionTextColor(Color.RED);


        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
        return;
    } else {
    Intent addEntryIntent = new Intent(this, homePage.class);
    startActivity(addEntryIntent);

    finish();
}