@Override
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
    MenuInflater inflater = getActivity().getMenuInflater();

switch (v.getTag().toString()) {
    case "Contacts":
        inflater.inflate(R.menu.contacts_context_menu, menu);
        menu.setHeaderTitle("Contact");
        break;
    case "Chats":
        inflater.inflate(R.menu.chat_contacts_context_menu, menu);
        menu.setHeaderTitle("Contact");
        break;
    case "GroupChats":
        inflater.inflate(R.menu.groups_context_menu, menu);
        menu.setHeaderTitle("Your Group");  
        break;

    default:
        break;
    }      
    }

    @Override
        public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);

        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

         Utils.logErrorMessage("info = "+info);
        switch (item.getItemId()) {
        case R.id.chatwithcontact:
    //...do something
     return true;
    }

    }//end method