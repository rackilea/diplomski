// display contact name on TextView in ListView
        String[] from = new String[]{"name"};
        int[] to = new int[]{R.id.contactTextView};
        //HERE!!
        contactAdapter = new SimpleCursorAdapter(AddressBook.this, R.layout.contact_list_item, null, from, to);
        setListAdapter(contactAdapter); // setting adaptercontactView
    }