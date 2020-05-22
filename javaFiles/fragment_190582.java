private String getAllWheelValues() {
 String val1 = getWheelValue(R.id.passw_1);
 String val2 = getWheelValue(R.id.passw_2);
 String val3 = getWheelValue(R.id.passw_3);

 return val1+" "+val2+" "+val3;
}

private String getWheelValue(int id) {
    WheelView wheel = getWheel(id);
    int index = wheel.getCurrentItem();
    return ((ArrayWheelAdapter<String>) wheel.getViewAdapter()).getItemText(index).toString();
}