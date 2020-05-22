int firstHouer = fromTimePicker.getHour();     // getCurrentHour() is deprecated
int firstdMinute = fromTimePicker.getMinute(); // getCurrentMinute() is deprecated
int seccoundHouer = toTimePicker.getHour();    // or whatever it is called
int seccoundMinute = toTimePicker.getMinute(); // or whatever it is called

if (60*firstHouer + firstdMinute < 60*seccoundHouer + seccoundMinute) {
    Toast toast = Toast.makeText(getApplicationContext(), "B" , Toast.LENGTH_LONG);
    toast.show();
}
else {
    Toast toast = Toast.makeText(getApplicationContext(), "A" , Toast.LENGTH_LONG);
    toast.show();
}