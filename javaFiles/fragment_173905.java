public class MainActivity extends FragmentActivity implements DatePickerFragment.OnDateSetListener {
    private static final int FROM_DATE_TAG = 2404;
    private static final int TO_DATE_TAG = 2405;

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DatePickerFragment fragment;
        switch(view.getId()){
        case R.id.fromDate:
            fragment = new DatePickerFragment();
            fragment.setOnDateSetListener(this, FROM_DATE_TAG);
            fragment.show(fragmentManager, "Date Picker");
            break;
        case R.id.toDate:
            fragment = new DatePickerFragment();
            fragment.setOnDateSetListener(this, TO_DATE_TAG);
            fragment.show(fragmentManager, "Date Picker");
            break;
        }
    }

    //If you want to update the alredy selected date, Specify it in budle. DatePickerFragment will take specified bundle date as default date.
    private void updateDate() {
        //get to date stored in SharedPrefrence
        String toDate = SharedPrefrenceUtils.getString(mContext, "FROM_DATE");
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        Date parse = sdf.parse(toDate);
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        FragmentManager fragmentManager = this.getActivity().getSupportFragmentManager();
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("YEAR", c.get(Calendar.YEAR));
        bundle.putInt("MONTH", c.get(Calendar.MONTH));
        bundle.putInt("DAY", c.get(Calendar.DATE));
        fragment.setArguments(bundle);
        fragment.setOnDateSetListener(this, FROM_DATE_TAG);
        fragment.show(fragmentManager, "Date Picker");
    }

    @Override
    public void onDateSet(DatePicker dialog, int year, int monthOfYear, int dayOfMonth, int reqCode) {
        if(reqCode == FROM_DATE_TAG){
            Calendar myCalendar  = Calendar.getInstance();
            myCalendar.set(year, monthOfYear, dayOfMonth);
            SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
            String dateString = formatter.format(myCalendar.getTime());
            Log.i("From Date","DATE:"+dateString);//"Result = DATE:May 24, 2015"
            //Store FROM_DATE in SharedPrefrence
            SharedPrefrenceUtils.putString(mContext,"FROM_DATE", dateString);
        } else if(reqCode == TO_DATE_TAG){
            Calendar myCalendar  = Calendar.getInstance();
            myCalendar.set(year, monthOfYear, dayOfMonth);
            SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
            String dateString = formatter.format(myCalendar.getTime());
            Log.i("To Date","DATE:"+dateString);//"Result = DATE:May 25, 2015"
            //Store TO_DATE in SharedPrefrence
            SharedPrefrenceUtils.putString(mContext,"TO_DATE", dateString);
        }
    }
}