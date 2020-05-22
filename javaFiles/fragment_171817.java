public class A {

    /**
     * @param args
     */
    public static void main(String[] args) {

        B obj = new B();
        obj.addPropertyChangeListener("valueChanged", new ValueChangeListener());
        obj.someMethodThatFiresChange();

    }

    private static final class ValueChangeListener implements PropertyChangeListener {

        public void propertyChange(PropertyChangeEvent event) {
            System.out.println("huhu");

            if(Boolean.TRUE.equals(event.getNewValue())) {
                System.out.println("haha");
             }

        }

    }

    private static final class B {

        private boolean valueChanged;

        private final PropertyChangeSupport pcSupport = new PropertyChangeSupport(this);

        public void setValueChanged(boolean b) {

            boolean oldVal = valueChanged;
            valueChanged = b;
            pcSupport.firePropertyChange("valueChanged", oldVal, valueChanged);
        }

        public void someMethodThatFiresChange() {
            setValueChanged(true);
            setValueChanged(false);
            setValueChanged(true);
        }

        public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
            pcSupport.addPropertyChangeListener(propertyName, listener);
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            pcSupport.addPropertyChangeListener(listener);
        }
    }

   }