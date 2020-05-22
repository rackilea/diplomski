public class SpinnerWindowModel extends SpinnerNumberModel {

    private Calendar calendar;
    private int calendarField;

    public SpinnerWindowModel(int calendarField, Calendar calendar, int value, int min, int max, int step) {
        super(value, min, max, step);
        this.calendar = calendar;
    }

    @Override
    public void setValue(Object value) {
        super.setValue(value);
        System.out.println(value);
    }

    public int getCalendarField() {
        return calendarField;
    }

    @Override
    public Object getPreviousValue() {
        Object obj = super.getPreviousValue();
        if (obj instanceof Integer)  {
            int fld = getCalendarField();
            calendar.set(fld, (int)obj);

            return obj;
        }

        return getValue();
    }

    @Override
    public Object getNextValue() {
        Object obj = super.getNextValue();
        if (obj instanceof Integer)  {
            int fld = getCalendarField();
            calendar.set(fld, (int)obj);

            return obj;
        }

        return getValue();
    }
}