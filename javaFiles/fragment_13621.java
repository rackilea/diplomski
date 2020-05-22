b3.setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View view) {
            if(timePickerDialog1==null)
                timePickerDialog1=new TimePickerDialog(1);

            if(timePickerDialog2==null)
                timePickerDialog1=new TimePickerDialog(2);

                hourTimer1 = ((TimePickerDialog) timePickerDialog1).hourOfDay;
                hourTimer2 = ((TimePickerDialog) timePickerDialog2).hourOfDay;
                minuteTimer1 = ((TimePickerDialog) timePickerDialog1).minute;
                minuteTimer2 = ((TimePickerDialog) timePickerDialog2).minute;
                AM_PMTimer1 = ((TimePickerDialog) timePickerDialog1).AM_PM;
                AM_PMTimer2 = ((TimePickerDialog) timePickerDialog2).AM_PM;
                //Log.i("trace1","test "+((TimePickerDialog) timePickerDialog1).hourOfDay);
                //Log.i("trace2","test "+((TimePickerDialog) timePickerDialog2).hourOfDay);
                time1Format = "" + hourTimer1 + ":" + minuteTimer1 + " " + AM_PMTimer1;
                time2Format = "" + hourTimer1 + ":" + minuteTimer1 + " " + AM_PMTimer2;
                Log.i("time1Format", "" + time1Format);
                Log.i("time2Format", "" + time2Format);
            }
        });