Bean bean = new Bean("Test", value1);
    BeanItem<Bean> beanItem = new BeanItem<Bean>(bean);
    for(Object propertyId: beanItem.getItemPropertyIds()) {
        System.out.println(" Property: '" + propertyId + 
                           "' value: " + beanItem.getItemProperty(propertyId));
    }