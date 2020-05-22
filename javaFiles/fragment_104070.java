DatePicker mDatePicker = (DatePicker) findViewById(R.id.date_picker);
     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
         int headerId = Resources.getSystem().getIdentifier("day_picker_selector_layout", "id", "android");
         final View header = mDatePicker.findViewById(headerId);
         header.setBackgroundColor(getResources().getColor(android.R.color.black));
     }