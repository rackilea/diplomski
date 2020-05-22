@Override
public void onStart() {
  super.onStart();
  list_item.setVisibility(View.VISIBLE);
}

@Override
public void onStop() {
  super.onStop();
  list_item.setVisibility(View.GONE);
}