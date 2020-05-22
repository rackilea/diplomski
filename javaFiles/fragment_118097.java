enum MapValueDirection {
    VALUE_TO_KEY,
    KEY_TO_VALUE
};

private class MappingConverter extends Converter {
    Map<String, String> map = null;

    public MappingConverter( Map<String, String> map_, MapValueDirection dir) {
        super(String.class, String.class);
        if (dir == MapValueDirection.VALUE_TO_KEY) {
            map = reverseMap(map_);
        } else {
            map = map_;
        }
    }

    private Map<String, String> reverseMap(Map<String, String> map_) {
        Map<String, String> reversedMap = new TreeMap<String, String>();
        Set<Entry<String, String>> entries = map_.entrySet();
        for (Entry<String, String> curEnt : entries) {
            reversedMap.put(curEnt.getValue(), curEnt.getKey());
        }
        return reversedMap;
    }


    /* (non-Javadoc)
     * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
     */
    public Object convert(Object fromObject) {
        if (map != null && fromObject != null && String.class.equals(fromObject.getClass())) {
            Object newVal = map.get(fromObject);
            if (newVal == null) {
                newVal = fromObject;
            }
            return newVal;
        }
        return fromObject;
    }
}

/**
 * And this is were the actual work gets done.
 */
public void bindBean(Object bean, PropertyDescriptor prop) {
  Control curControl = getControl(prop.getPropertyType());
  IObservableValue uiElement = getObserver(prop, curControl);
  IOvservableValue modelElement = BeanObservables.observValue(bean, prop.getName());

  // "display" = key, "storage" = value
  Map<String, String> profileFlds = getProfileFields();

  UpdateValueStrategy toStorage = new UpdateValueStrategy();
  toStorage.setConverter( new MappingConverter( profileFlds, MapValueDirection.KEY_TO_VALUE));

  UpdateValueStrategy toDisplay = new UpdateValueStrategy();
  toDisplay .setConverter( new MappingConverter( profileFlds, MapValueDirection.VALUE_TO_KEY));

  m_bindingContext.bindValue( uiElement, modelElement, toDisplay , toStorage);
}