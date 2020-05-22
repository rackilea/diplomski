import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GridWithLocalTimeField extends VerticalLayout {
    public GridWithLocalTimeField() {
        // basic grid setup, double click row to edit
        BeanItemContainer<MyBean> container = new BeanItemContainer<>(MyBean.class);
        Grid grid = new Grid();
        grid.setContainerDataSource(container);
        grid.setEditorEnabled(true);
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        addComponent(grid);

        // add a custom field for editing the LocalTime field
        TextField dateFieldEditor = new TextField();
        dateFieldEditor.setConverter(new StringToLocalTimeConverter());

        // configure grid column for the LocalTime field
        grid.getColumn("time")
                .setMinimumWidth(100)
                .setConverter(new StringToLocalTimeConverter())
                .setResizable(false)
                .setEditorField(dateFieldEditor); // comment this to get the stacktrace

        // add some dummy data
        for (int i = 0; i < 10; i++) {
            container.addBean(new MyBean(LocalTime.now(), i));
        }
    }

    public static class StringToLocalTimeConverter implements Converter<String, LocalTime> {
        public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

        @Override
        public LocalTime convertToModel(String value, Class<? extends LocalTime> targetType, Locale locale) throws ConversionException {
            if (value == null || value.isEmpty()) {
                return null;
            } else {
                return LocalTime.parse(value, TIME_FORMATTER);
            }
        }

        @Override
        public String convertToPresentation(LocalTime value, Class<? extends String> targetType, Locale locale) throws ConversionException {
            if (value == null) {
                return "";
            } else {
                return value.format(TIME_FORMATTER);
            }
        }

        @Override
        public Class<LocalTime> getModelType() {
            return LocalTime.class;
        }

        @Override
        public Class<String> getPresentationType() {
            return String.class;
        }
    }

    public static class MyBean {
        private LocalTime time;
        private int order;

        public MyBean(LocalTime time, int order) {
            this.time = time;
            this.order = order;
        }

        public LocalTime getTime() {
            return time;
        }

        public void setTime(LocalTime time) {
            this.time = time;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }
}