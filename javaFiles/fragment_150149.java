imbtnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Cursor cursor = dbManager.fetch(DatabaseHelper.TICKET_TABLE);
                    File file = new File(Environment.getExternalStorageDirectory(),"Report-"+DateUtil.timeMilisToString(System.currentTimeMillis(),"hh-MM-yy")+".xls");
                    Toast.makeText(getApplicationContext(),"File saved",Toast.LENGTH_LONG).show();

                    WorkbookSettings wbSettings = new WorkbookSettings();
                    wbSettings.setLocale(new Locale("en", "EN"));
                    WritableWorkbook workbook;
                    workbook = Workbook.createWorkbook(file, wbSettings);
                    WritableSheet sheet = workbook.createSheet("Daily Report", 0);

                    // column and row
                    sheet.addCell(new Label(0, 0, "Pass Report"));
                    sheet.addCell(new Label(1, 0, "User"));

                    if (cursor.moveToFirst()) {
                        do {
                            String Rno = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TICKET_RECEIPT));
                            String vno = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TICKET_V_NO));
                            String vtype = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TICKET_V_TYPE));
                            String vin = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TICKET_V_IN_TIME));
                            String vout = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TICKET_V_OUT_TIME));
                            int i = cursor.getPosition() + 1;
                            sheet.addCell(new Label(0, i, Rno));
                            sheet.addCell(new Label(1, i, vno));
                            sheet.addCell(new Label(2, i, vtype));
                            sheet.addCell(new Label(3, i, vin));
                            sheet.addCell(new Label(4, i, vout));
                        } while (cursor.moveToNext());
                    }

                    //closing cursor
                    cursor.close();
                    workbook.write();
                    workbook.close();

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"email@example.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject here");
                    intent.putExtra(Intent.EXTRA_TEXT, "body text");
                    if (!file.exists() || !file.canRead()) {
                        Toast.makeText(getApplicationContext(), "Attachment Error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Uri uri = Uri.fromFile(file);
                    intent.putExtra(Intent.EXTRA_STREAM, uri);
                    startActivity(Intent.createChooser(intent, "Send email..."));
                }
                catch (Exception e){e.printStackTrace();}
            }
        });