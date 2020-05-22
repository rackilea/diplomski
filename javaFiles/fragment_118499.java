private void update(String s, boolean b) {
    textview .setText(s);

    if (b == false) {
        textview .setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
    }

    else {
        textview.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
    }
}