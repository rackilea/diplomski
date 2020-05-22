public void displayNewLeadData() 
    {
        dbAdapter=new DataBase_Adapter(Serach_Data.this).open();
        dataBase = dbAdapter.getDatabaseInstance();

        Cursor mCursor = dataBase.rawQuery("SELECT * FROM " + DataBase_Adapter.TABLE_NEW_LEAD, null);
        mCursor.moveToFirst();
        arrayList_newLead_Id.clear();
        arrayList_newLead_Name.clear();
        arrayList_newLead_Email.clear();
        arrayList_newLead_Mobile.clear();
        arrayList_newLead_Products.clear();
        arrayList_newLead_Budget.clear();
        arrayList_newLead_Priority.clear();
        arrayList_newLead_Status.clear();
        arrayList_newLead_Notes.clear();
        arrayList_newLead_Reminder_Date.clear();
        arrayList_newLead_Reminder_Time.clear();
        arrayList_newLead_AddToContact.clear();




            do 
            {
                arrayList_newLead_Id.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_ID)));
                arrayList_newLead_Name.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_NAME)));
                arrayList_newLead_Email.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_EMAIL)));
                arrayList_newLead_Mobile.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_MOBILE)));
                arrayList_newLead_Products.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_Product)));
                arrayList_newLead_Budget.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_BUDGET)));
                arrayList_newLead_Priority.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_PRIORITY)));
                arrayList_newLead_Status.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_STATUS)));
                arrayList_newLead_Notes.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_NOTES)));
                arrayList_newLead_Reminder_Date.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_REMINDER_DATE)));
                arrayList_newLead_Reminder_Time.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_REMINDER_TIME)));
                arrayList_newLead_AddToContact.add(mCursor.getString(mCursor.getColumnIndex(DataBase_Adapter.KEY_NEW_LEAD_ADDtoCONTACTS)));



            } while (mCursor.moveToNext());


        new_Lead_List_Adapter = new New_Lead_List_Adapter(Serach_Data.this , arrayList_newLead_Id ,
                                                        arrayList_newLead_Name , arrayList_newLead_Email,
                                                        arrayList_newLead_Mobile , arrayList_newLead_Products,
                                                        arrayList_newLead_Budget , arrayList_newLead_Priority ,
                                                        arrayList_newLead_Status , arrayList_newLead_Notes ,
                                                        arrayList_newLead_Reminder_Date , arrayList_newLead_Reminder_Time ,
                                                        arrayList_newLead_AddToContact );

        newLeadDat_List.setAdapter(new_Lead_List_Adapter);
        new_Lead_List_Adapter.notifyDataSetChanged();
        mCursor.close();
        System.out.println("Data will Be Display.");

    }