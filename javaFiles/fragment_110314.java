static long MaximumDate=0,MinimunDate=0;

dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

    View.OnClickListener showDatePicker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final View vv = v;

            Calendar newCalendar=Calendar.getInstance();    

            switch (vv.getId()) {
            case R.id.txtFromUpdatedDate_MgntNC:

                DatePickerDialog dialogFrom=new DatePickerDialog(MgntNCActivity.this, new OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                            int monthOfYear, int dayOfMonth) {
                        Calendar upDateFrom = Calendar.getInstance();
                        upDateFrom.set(year, monthOfYear, dayOfMonth);
                        txtFromUpdatedDate.setText(dateFormatter.format(upDateFrom.getTime()));

                        MinimunDate=upDateFrom.getTimeInMillis();


                    }

                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


                if (MaximumDate!=0) {
                    dialogFrom.getDatePicker().setMaxDate(MaximumDate);
                }else{
                    dialogFrom.getDatePicker().setMaxDate(NetworkUtil.getTodayDate().getTime());
                }

                dialogFrom.show();

                dialogFrom.setOnCancelListener(new DialogInterface.OnCancelListener() {

                    @Override
                    public void onCancel(DialogInterface arg0) {
                        MinimunDate=0;

                         txtFromUpdatedDate.setText(Constant.NoValue);
                    }
                });

                break;

            case R.id.txtToUpdatedDate_MgntNC:
                DatePickerDialog dialogTo=new DatePickerDialog(MgntNCActivity.this, new OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                            int monthOfYear, int dayOfMonth) {
                        Calendar upDateTo = Calendar.getInstance();
                        upDateTo.set(year, monthOfYear, dayOfMonth);
                        txtToUpdatedDate.setText(dateFormatter.format(upDateTo.getTime()));

                        MaximumDate=upDateTo.getTimeInMillis();

                    }

                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

                dialogTo.getDatePicker().setMaxDate(NetworkUtil.getTodayDate().getTime());
                if (MinimunDate!=0) {
                    dialogTo.getDatePicker().setMinDate(MinimunDate);
                }else{
                    //dialog1.getDatePicker().setMinDate(NetworkUtil.getTodayDate().getTime());
                }

                dialogTo.show();

                dialogTo.setOnCancelListener(new DialogInterface.OnCancelListener() {

                    @Override
                    public void onCancel(DialogInterface arg0) {
                        MaximumDate=0;

                    }
                });


                break;  

            default:
                break;
            }



        }
    };

    txtFromUpdatedDate.setOnClickListener(showDatePicker);
    txtToUpdatedDate.setOnClickListener(showDatePicker);