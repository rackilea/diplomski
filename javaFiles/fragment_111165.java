@Override
public void unregisterDataSetObserver(DataSetObserver observer) {
  super.unregisterDataSetObserver(observer);

  Log.d("Adapter just got unregistered from the listView!");
  [...]
}