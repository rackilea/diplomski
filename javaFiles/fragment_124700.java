public static class MyBeanDeserializerModifier extends BeanDeserializerModifier {

    @Override
    public BeanDeserializerBuilder updateBuilder(DeserializationConfig config, 
                     BeanDescription beanDesc, BeanDeserializerBuilder builder) {
        if (beanDesc.getBeanClass() != Contact.class) {
            return builder;
        }

        List<PropertyName> properties = new ArrayList<>();
        Iterator<SettableBeanProperty> beanPropertyIterator = builder.getProperties();
        Class<?> activeView = config.getActiveView();


        while (beanPropertyIterator.hasNext()) {
            SettableBeanProperty settableBeanProperty = beanPropertyIterator.next();
            if (!settableBeanProperty.visibleInView(activeView)) {
                properties.add(settableBeanProperty.getFullName());
            }
        }

        for(PropertyName p : properties){
            builder.removeProperty(p);
        }

        return builder;
    }
}