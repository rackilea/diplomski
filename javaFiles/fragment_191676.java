ChangeListener<Object> listener = (observable, oldValue, newValue) -> {
    ObjectProperty objProp = (ObjectProperty) observable ;
    Object bean = objProp.getBean();
    // do something....
};

someProperty.addListener(listener);
someOtherProperty.addListener(listener);