Cursor c = db.rawQuery("SELECT * from Data", null);
int count = c.getCount();
c.moveToFirst();
 TableLayout table=new TableLayout;
                  table.setGravity(Gravity.CENTER);

      table.setStretchAllColumns(true);
      table.setShrinkAllColumns(true);

                TableRow rowLabels = new TableRow(this);
                rowLabels.setLayoutParams(new LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

                rowLabels.setBackgroundDrawable(getResources().getDrawable(
                        R.xml.tablerow));

                TextView srnoLabel = new TextView(this);
                srnoLabel.setText("FirstName");
                srnoLabel.setTypeface(Typeface.SERIF, Typeface.BOLD);
                srnoLabel.setTextColor(Color.RED);
                srnoLabel.setPadding(40, 5, 0, 5);
                srnoLabel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
                rowLabels.addView(srnoLabel);

                TextView pLabel = new TextView(this);
                pLabel.setText("Middle Name");
                pLabel.setTypeface(Typeface.SERIF, Typeface.BOLD);
                pLabel.setTextColor(Color.RED);
                pLabel.setPadding(20, 5, 0, 5);
                pLabel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
                rowLabels.addView(pLabel);

                TextView valLabel = new TextView(this);
                valLabel.setText("Last Name");
                valLabel.setTypeface(Typeface.SERIF, Typeface.BOLD);
                valLabel.setTextColor(Color.RED);
                valLabel.setPadding(40, 5, 0, 5);
                valLabel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
                rowLabels.addView(valLabel);
                rowLabels.setPadding(0, 0, 10, 0);


if (c.moveToFirst()) {
                    do {
                    String f_name = c.getString(c
                                .getColumnIndex("fname"));
                    String l_name = c.getString(c
                                .getColumnIndex("lname"));
                    String m_name = c.getString(c
                                .getColumnIndex("mname"));      

                    TableRow rowdata = new TableRow(this);
                        rowdata.setLayoutParams(new LayoutParams(
                                LayoutParams.WRAP_CONTENT,
                                LayoutParams.WRAP_CONTENT));
                        // 1 column
                        TextView f_txt = new TextView(this);

                        f_txt.setText(Integer.toString(count));
                        f_txt.setPadding(50, 3, 10, 3);
                        f_txt.setText(f_name);
                        f_txt.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
                        f_txt.setTextColor(Color.BLACK);
                        f_txt.setClickable(true);
                        rowdata.addView(f_txt);


                    // 2 column
                        final TextView m_txt = new TextView(this);
                        m_txt.setText(m_name);
                        m_txt.setPadding(15, 3, 10, 3);
                        m_txt
                                .setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
                        m_txt.setTextColor(Color.BLACK);
                        rowdata.addView(m_txt);

                            // 3 column
                        final TextView l_txt = new TextView(this);
                        l_txt.setText(l_name);
                                //Annual_crop_loss.toString());
                        l_txt.setPadding(45, 3, 10, 3);
                        l_txt.setTextSize(
                                TypedValue.COMPLEX_UNIT_DIP, 17);
                        l_txt.setTextColor(Color.BLACK);
                        rowdata.addView(m_txt);
                        rowdata.setPadding(1, 1, 1, 1);

                    table.addView(rowLabels);
                        table.addView(rowdata);
                    }

                    } while (c.moveToNext());

                    table.setPadding(10, 10, 10, 10);
                    setContentView(table);
                }   
finally {
        if (dbase != null)
            // newDB.execSQL("DELETE FROM " + tableName);
            c.close();
            dbase.close();
    }