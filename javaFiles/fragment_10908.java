@Override
public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
 int position = tab.getPosition();
 DataUpdate dataUpdate = (DataUpdate) TabAdapter.getItem(position);
 // Pass the master workdata to the selected fragment
 dataUpdate.setData(this.workData);
}

@Override
public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
 int position = tab.getPosition();
 DataUpdate dataUpdate = (DataUpdate) TabAdapter.getItem(position);
 // Update the master workdata from the unselected fragment
 this.workData = dataUpdate.getData();
}

@Override
public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
 // This might be pointless, but we'll do it anyway..
 int position = tab.getPosition();
 DataUpdate dataUpdate = (DataUpdate) TabAdapter.getItem(position);
 // Pass the master workdata to the selected fragment
 dataUpdate.setData(this.workData);
}