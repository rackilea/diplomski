void assertSameProperties(Class class1, Class class2) {
    Set<String> properties = new HashSet<String>();
    for (PropertyDescriptor prop : BeanUtils.getPropertyDescriptors(class1)) {
        properties.add(prop.getName());
    }
    for (PropertyDescriptor prop : BeanUtils.getPropertyDescriptors(class2)) {
        if (!properties.remove(prop.getName()) {
            fail("Class " + class2.getName() + " has extra property " + prop.getName());
        }
    }
    if (!properties.isEmpty()) {
        fail("Class " + class1.getName() + " has extra properties");
    }

}