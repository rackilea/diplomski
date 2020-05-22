private class LoginButtonListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(v.getContext(), MasterUserActivity.class);
        v.getContext().startActivity(intent);

    }
}