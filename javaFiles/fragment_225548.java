public class MyDatePicker extends VerticalLayout {

    private InlineDateField dateField;
    private NativeSelect hourPicker;
    private NativeSelect minutePicker;

    public MyDatePicker(String caption) {
        setSizeUndefined();

        dateField = new InlineDateField(caption);
        hourPicker = new NativeSelect();
        minutePicker = new NativeSelect();

        HorizontalLayout hourLayout = new HorizontalLayout();
        hourLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        Label colonLabel = new Label("<b>:</b>");
        colonLabel.setContentMode(ContentMode.HTML);
        hourLayout.addComponents(hourPicker, colonLabel, minutePicker);

        addComponents(dateField, hourLayout);
        setComponentAlignment(hourLayout, Alignment.MIDDLE_CENTER);

        setValues();
    }

    private void setValues() {
        hourPicker.setContainerDataSource(new BeanItemContainer<>(String.class, new ArrayList<>(Arrays.asList("01", "02", "...", "24"))));
        minutePicker.setContainerDataSource(new BeanItemContainer<>(String.class, new ArrayList<>(Arrays.asList("00", "15", "30", "45"))));

        hourPicker.select("01");
        minutePicker.select("00");
    }

    public Date getValue() {
        Date date = dateField.getValue();

        // set hour and minutes to date

        return date;
    }

}