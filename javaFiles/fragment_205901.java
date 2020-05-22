public class SpinnerWindowModel extends SpinnerDateModel {

    public SpinnerWindowModel() {
        super();
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(1970, Calendar.JANUARY, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date startTime = cal.getTime();

        cal.set(1970, Calendar.JANUARY, 23, 59, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date endTime = cal.getTime();

        System.out.println(startTime);
        System.out.println(endTime);

        Calendar value = Calendar.getInstance();
        value.set(1970, Calendar.JANUARY, 0, 0, 0);
        value.set(Calendar.MILLISECOND, 0);

        setStart(startTime);
        setEnd(endTime);
        setValue(value.getTime());
        setCalendarField(Calendar.MINUTE);
    }

    @Override
    public Object getPreviousValue() {
        int fld = getCalendarField();

        Object value = super.getPreviousValue();

        if (fld == Calendar.MINUTE) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(getDate());
            cal.add(Calendar.MINUTE, -15);
            value = cal.getTime();
        }

        return value;
    }

    @Override
    public Object getNextValue() {
        int fld = getCalendarField();
        Object value = super.getNextValue();

        if (fld == Calendar.MINUTE) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(getDate());
            cal.add(Calendar.MINUTE, 15);
            value = cal.getTime();
        }

        return value;
    }
}