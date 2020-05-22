protected Dialog onCreateDialog(int id) {

    switch (id) {
    case DATE_PICKER_FROM:
        return new DatePickerDialog(this, from_dateListener, from_year,
                from_month, from_day);
    case DATE_PICKER_TO:
        return new DatePickerDialog(this, to_dateListener, to_year,
                to_month, to_day);
    }
    return null;
}