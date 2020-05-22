public void addListenerOnButton() 
    {   
        Button add = (Button) getView().findViewById(R.id.add_button);
        add.bringToFront(); // <--- this line
        add.setOnClickListener(new View.OnClickListener()
        {
        public void onClick(View v)
        {
            Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,  
                    Contacts.CONTENT_URI);  
            startActivityForResult(contactPickerIntent, CONTACT_PICKER_RESULT);  
        }});
    }