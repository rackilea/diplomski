new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,monthOfYear + 1,dayOfMonth);

        long timeInMilliseconds = 
        calendar.getTimeInMillis()+TimeUnit.DAYS.toMillis(280);

        calendar.setTimeInMillis(timeInMilliseconds);

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
                                eText.setText(mDay + "/" + mMonth + "/" + mYear);
                            }
                        }, year, month, day);
                picker.show();
            }
        });