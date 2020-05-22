hora_text.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) { 
        Calendar cal = Calendar.getInstance();
        int hora = cal.get(Calendar.HOUR);
        int minutos = cal.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker = new TimePickerDialog(getActivity(),TimePickerDialog.THEME_HOLO_LIGHT,hourSetListener,hora,minutos,true);
        mTimePicker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mTimePicker.show();
    }
);