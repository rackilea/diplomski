public void onDestroy() {
    super.onDestroy();
    // close database
    final MySqlHelper helper = MySqlHelper.getInstance();
    helper.getDatabase().close();
}