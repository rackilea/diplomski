if (!rootIsChecked) {
    if (!"animalList".equals(elementName)) {
       throw new IllegalArgumentException("Wrong root element");
    }
    rootIsChecked = true;
}
// continue parsing...