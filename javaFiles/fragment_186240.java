//View
    IObservableValue comboObservable = WidgetProperties.singleSelectionIndex().observe(combo);
    IObservableValue viewTypeObservable = BeanProperties.value(DebugModel.class, "type").observe(debugModel);

    IConverter viewTypeToIntConverter = createViewTypeToIntConverter();
    UpdateValueStrategy toTargetStrategy = new UpdateValueStrategy();
    toTargetStrategy.setConverter(viewTypeToIntConverter);

    IConverter intToViewTypeConverter = createIntToViewTypeConverter();
    UpdateValueStrategy toModelStrategy = new UpdateValueStrategy();
    toModelStrategy.setConverter(intToViewTypeConverter);

    DataBindingContext context = new DataBindingContext();
    context.bindValue(comboObservable, viewTypeObservable, toModelStrategy, toTargetStrategy);

//Converter
private IConverter createIntToViewTypeConverter() {
    return new IConverter() {

        @Override
        public Object convert(Object value) {
            if(value instanceof Integer) {
                for(ViewType type : ViewType.values()) {
                    if(type.toString().equals(ViewType.getStringAtIndex((int)value))) {
                        return type;
                    }
                }
            }
            throw new IllegalArgumentException("We need an Integer to convert it but got an " + value.getClass());
        }

        @Override
        public Object getFromType() {
            return Integer.class;
        }

        @Override
        public Object getToType() {
            return ViewType.class;
        }

    };
}

private IConverter createViewTypeToIntConverter() {
    return new IConverter() {

        @Override
        public Object convert(Object value) {
            if(value instanceof ViewType) {
                String[] viewTypes = ViewType.getStringValues();
                for(int i=0;i<viewTypes.length;i++) {
                    if(viewTypes[i].equals(((ViewType)value).toString())) {
                        return i;
                    }
                } 
            }
            throw new IllegalArgumentException("We need a View Type to be converted but got a " + value.getClass());
        }

        @Override
        public Object getFromType() {
            return ViewType.class;
        }

        @Override
        public Object getToType() {
            return Integer.class;
        }

    };
}

//Model
public class DebugModel extends ModelObject {
    private ViewType type;
    public ViewType getType() {
         return type;
    }

    public void setType(ViewType type) {
        firePropertyChange("type", this.type, this.type = type);
    }
}

//Just to complete the example, be sure the Model class extends a ModelObject class like this
public class ModelObject {
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(
        this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName,
        PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName,
        PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(propertyName, listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue,
        Object newValue) {
        changeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    protected void fireIndexedPropertyChange(String propertyName, int index, Object oldValue, Object newValue) {
        changeSupport.fireIndexedPropertyChange(propertyName, index, oldValue, newValue);
    }
}