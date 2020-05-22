contact = new Contact();
    contact.setName(editName.getText().toString());
    maarakhContact = new ArrayList<>();

    //Add the contact class to arraylist
    maarakhContact.add(contact);

    Intent intent = new Intent();
    intent.putExtra("mylist", maarakhContact);
    setResult(2, intent);
    finish();