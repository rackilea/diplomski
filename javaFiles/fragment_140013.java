Uri simUri = Uri.parse("content://icc/adn"); 
    Cursor cursorSim = this.getContentResolver().query(simUri,null,null,null,null);

    while (cursorSim.moveToNext()) 
    {      
        ClsSimPhonename =cursorSim.getString(cursorSim.getColumnIndex("name"));
        ClsSimphoneNo = cursorSim.getString(cursorSim.getColumnIndex("number"));
        ClsSimphoneNo.replaceAll("\\D","");
        ClsSimphoneNo.replaceAll("&", "");
        ClsSimPhonename=ClsSimPhonename.replace("|","");
            System.out.println("SimContacts"+ClsSimPhonename);
            System.out.println("SimContactsNo"+ClsSimphoneNo);
            dts.createDatabse("MyCellFamily",getApplicationContext());

    }        
}
catch(Exception e)
{
    e.printStackTrace();
}