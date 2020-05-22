for (Tag tag : sm.getBlock4().getTags()) {
    Field field = tag.asField();
    System.out.println("\n" + Field.getLabel(field.getName(), "103", null, locale));
    for (int component = 1 ; component <= field.componentsSize() ; component++) {
        if (field.getComponent(component) != null) {
            System.out.print(field.getComponentLabel(component) + ": ");
            System.out.println(field.getValueDisplay(component, locale));
        }
    }
}