@Override
public void onCreate(Bundle bundle) {
    super.onCreate(bundle);       
    final Cursor c = managedQuery(Contacts.CONTENT_URI, 
                                new String[]{Contacts._ID, Contacts.DISPLAY_NAME}, 
                                Contacts.DISPLAY_NAME + " != ?", new String[] {"NULL"}, 
                                Contacts.DISPLAY_NAME );

    String[] from = new String[] { android.provider.ContactsContract.Contacts.DISPLAY_NAME };
    int[] to = new int[] { R.id.nativecontacts_entry_name };
    SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.rawlayout, c, from, to);

    setListAdapter(adapter);
}