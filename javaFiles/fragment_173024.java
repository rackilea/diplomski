public ArrayList<String> smsBuffer = new ArrayList<String>();
    String smsFile = "SMS"+".csv";
       private void  backupSMS(){
    smsBuffer.clear();
    Uri mSmsinboxQueryUri = Uri.parse("content://sms");
    Cursor cursor1 = getContentResolver().query(
            mSmsinboxQueryUri,
            new String[] { "_id", "thread_id", "address", "person", "date",
                    "body", "type" }, null, null, null);
    //startManagingCursor(cursor1);
    String[] columns = new String[] { "_id", "thread_id", "address", "person", "date", "body",
            "type" };
    if (cursor1.getCount() > 0) {
        String count = Integer.toString(cursor1.getCount());
        Log.d("Count",count);
        while (cursor1.moveToNext()) {

             String messageId = cursor1.getString(cursor1
                    .getColumnIndex(columns[0]));

             String threadId = cursor1.getString(cursor1
                    .getColumnIndex(columns[1]));

            String address = cursor1.getString(cursor1
                    .getColumnIndex(columns[2]));
            String name = cursor1.getString(cursor1
                    .getColumnIndex(columns[3]));
            String date = cursor1.getString(cursor1
                    .getColumnIndex(columns[4]));
            String msg = cursor1.getString(cursor1
                    .getColumnIndex(columns[5]));
            String type = cursor1.getString(cursor1
                    .getColumnIndex(columns[6]));



            smsBuffer.add(messageId + ","+ threadId+ ","+ address + "," + name + "," + date + " ," + msg + " ,"
                    + type);

        }           
        generateCSVFileForSMS(smsBuffer);
    }               
}


 private void generateCSVFileForSMS(ArrayList<String> list)
{

    try 
    {
        String storage_path = Environment.getExternalStorageDirectory().toString() + File.separator + smsFile;
        FileWriter write = new FileWriter(storage_path);

        write.append("messageId, threadId, Address, Name, Date, msg, type");
        write.append('\n');

        for (String s : list)
        {
            write.append(s);
            write.append('\n');
        }
        write.flush();
        write.close();
    }

    catch (NullPointerException e) 
    {
        System.out.println("Nullpointer Exception "+e);
         //  e.printStackTrace();
     }
    catch (IOException e) 
    {
        e.printStackTrace();
    }
    catch (Exception e) 
    {
        e.printStackTrace();
   }

}