@Override
public void onDestroy() {
    updateDatabaseFromTheList();
    super.onDestroyView();
}

@Override
public void onPause() {
    updateDatabaseFromTheList();
    super.onDestroyView();
}