if (properties != null && !properties.isEmpty()) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(instance);
        beanWrapper.setAutoGrowNestedPaths(true);

        for (Iterator<?> iterator = properties.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String, ?> entry = (Map.Entry<String, ?>) iterator.next();
            String propertyName = entry.getKey();
            if (beanWrapper.isWritableProperty(propertyName)) {
                beanWrapper.setPropertyValue(propertyName, entry.getValue());
            }
        }
    }
}