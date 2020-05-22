DatabaseHandler db = new DatabaseHandler(this);
  Contact contact = db.getContact(15); //This is your what you call Database object

  //get View element
  TextView contactTextView = (TextView) findViewById(R.id.textView2);
  //Set contact information in the TextView
  contactTextView.setText(contact.getMD());