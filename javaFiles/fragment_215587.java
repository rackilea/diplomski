readData(new MyCallback() {
    @Override
    public void onCallback(UserAccountSettings settings) {
        Log.d("TAG", settings.getDisplay_name());
    }
});