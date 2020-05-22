Calendar cal = Calendar.getInstance();
int day = cal.get(Calendar.DAY_OF_WEEK);

switch(day) {
    case Calendar.MONDAY:
        imageViewMon.setColorFilter(0xFFFF3D60);
        break;
        ...
}