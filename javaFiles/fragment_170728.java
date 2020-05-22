@Override
protected void onResume() {
   super.onResume();
   //Creation de ladapter
   contacts.clear();
   db = new ContactDatabase(this);
   contacts.addAll(db.getData());
   adapter.notifyDataSetChanged();
}