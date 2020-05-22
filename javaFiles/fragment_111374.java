for(Map.Entry<String, String> entry : settings.entrySet()){
    try{
                key = entry.getKey();
                Class propertyClass = PropertyUtils.getPropertyDescriptor(bean, key).getPropertyType();
                if (propertyClass.getName().equals('Integer')) {
                    PropertyUtils.setProperty(bean, key, Integer.parseInt(entry.getValue()));
                } // and so with other types.
    }
    catch(Exception ex)
    {
        LOGGER.debug("failed...."+ex.getMessage());     
    }
}