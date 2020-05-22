@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    DataBaseOperations hell = new DataBaseOperations(getActivity());
    SQLiteDatabase db = hell.getReadableDatabase();
    String[] columns = {mDatabase.Tableinfo.ID,mDatabase.Tableinfo.Contacts_phone,mDatabase.Tableinfo.Contacts_name,mDatabase.Tableinfo.Contact_pic};
    Cursor Contacts = db.query(mDatabase.Tableinfo.contacts, columns, null, null, null, null, null);
    ContactsAdapter adapter = new ContactsAdapter(getContext(), Contacts,0);
    Contacts.close();
    lview = inflater.inflate(R.layout.fragment_contacts_list, container, false);
    ListView iv = (ListView)lview.findViewById(R.id.contacts);
    iv.setAdapter(adapter);
    return lview;
}