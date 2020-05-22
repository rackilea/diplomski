public static TimePickerFragment newInstance(Context context, TimePickedListener listener, Calendar now)
    {
        TimePickerFragment dialog = new TimePickerFragment();
        mContext = context;
        mListener = listener;
        hour = now.get(Calendar.HOUR_OF_DAY);
        minute = now.get(Calendar.MINUTE);

        return dialog;
    }