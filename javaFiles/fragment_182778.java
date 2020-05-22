delimageButton.setOnClickListener(new OnClickListener() {
    private int id = c.getInt(c.getColumnIndex(MyDBAdapter.KEY_ID));
    @Override
    public void onClick(View arg0) {
        Toast.makeText(t,
            "Delete ID: " + id, Toast.LENGTH_SHORT).show();
    }
});