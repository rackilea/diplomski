private void setDatePickerHeaderBackgroundColor(DatePickerDialog dpd, int color) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        try {
            Field mDatePickerField;
            mDatePickerField = DatePickerDialog.class.getDeclaredField("mDatePicker");
            mDatePickerField.setAccessible(true);
            final DatePicker mDatePicker = (DatePicker) mDatePickerField.get(dpd);

            int headerId = Resources.getSystem().getIdentifier("day_picker_selector_layout", "id", "android");
            final View header = mDatePicker.findViewById(headerId);
            header.setBackgroundColor(color);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}