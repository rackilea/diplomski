private void updateUserStatus(boolean online) {
    user.put("online", online);
    user.saveEventually();
}

@Override
protected void onDestroy() {
    super.onDestroy();
    updateUserStatus(false);
}

@Override
public void onResume() {
    super.onResume();
    loadUserList();
}

 public void loadUserList() {
    ParseUser.getQuery().whereNotEqualTo("username", user.getUsername())
            .findInBackground(new FindCallback<ParseUser>() {
                @Override
                public void done(List<ParseUser> li, ParseException e) {
                    if (li != null) {
                        if (li.size() == 0) {
                            Toast.makeText(getApplicationContext(),
                                    "No users found.", Toast.LENGTH_LONG)
                                    .show();

                            uList = new ArrayList<ParseUser>(li);
                            ListView list = (ListView) findViewById(R.id.userListView);
                            list.setAdapter(new UserAdapter());
                        }
                    }
                }
            });

}