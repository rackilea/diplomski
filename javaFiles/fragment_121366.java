BeanDescriptor beanDescriptor = validator.getConstraintsForClass( Employee.class );

Set<PropertyDescriptor> propertyDescriptors = beanDescriptor.getConstrainedProperties();

for(PropertyDescriptor propertyDescriptor : propertyDescriptors) {
    Set<ConstraintDescriptor<?>> descriptorsForGroup = propertyDescriptor.findConstraints()
                .unorderedAndMatchingGroups( EmployeeScreen.class )
                .getConstraintDescriptors();

     // if descriptorsForGroup is not empty you found a property which has a constraint matching the specified group
     // propertyDescriptor.getPropertyName() gets you the property name

}