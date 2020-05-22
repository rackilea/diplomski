findViewById(R.id.choose_contact_button).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
            Intent pickContact = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
            startActivityForResult(pickContact, PICK_CONTACT_REQUEST);
      }
 });