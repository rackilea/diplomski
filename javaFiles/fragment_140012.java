try
{
    String[] PROJECTION=new String[] {Contacts._ID,
        Contacts.DISPLAY_NAME,
        Phone.NUMBER
    };

    Cursor c=managedQuery(Phone.CONTENT_URI,
        PROJECTION, null, null, null);
        if (c.moveToFirst()) {
            String ClsPhonename = null;
            String ClsphoneNo = null;

            do 
            {
                ClsPhonename = c.getString(c.getColumnIndex(Contacts.DISPLAY_NAME));
                ClsphoneNo = c.getString(c.getColumnIndex(Phone.NUMBER));


                ClsphoneNo.replaceAll("\\D", "");
                ClsPhonename=ClsPhonename.replaceAll("&", "");
                ClsPhonename.replace("|","");
                String ClsPhoneName=ClsPhonename.replace("|","");

                }   

            } while(c.moveToNext());
        }