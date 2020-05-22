FeedsListAdapter adapter = ...;
adapter.setOnItemClickListener(new ContactsAdapter.OnItemClickListener() {
    @Override
    public void onAutoLinkTextClick(String companyId) {
      Intent intent = new Intent(activity, AboutUsActivity.class);
       intent.putExtra("companyId", f.getCompanyId());
      activity.startActivity(intent);
    }
});