Uri myMessage = Uri.parse("content://sms/");

                    ContentResolver cr = con.getContentResolver();
                    Cursor c = cr.query(myMessage, new String[] { "_id",
                            "address", "date", "body", "read" }, null,
                            null, null);

                    startManagingCursor(c);
                    Main_calss.getSmsLogs(c, con);