@Override
                           protected void onPrepareDialog(int id, Dialog dialog) {
                               switch (id) {
                                   case TIME_DIALOG_ID:
                                       ((TimePickerDialog) dialog).updateTime(mHour, mMinute);
                                       break;
                                   case DATE_DIALOG_ID:
                                       ((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
                                       break;
                               }
                           }