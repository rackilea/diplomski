Enumeration<Component> elements = styleButtonGroup.getElements();
while(elements.hasMoreElements()){
        mainPanel.add(elements.nextElement());
        mainPanel.add(elements.nextElement());
        mainPanel.add(elements.nextElement());
        mainPanel.add(elements.nextElement());
        mainPanel.add(elements.nextElement());
        System.out.println(elements.hasMoreElements() + " " + styleButtonGroup.getButtonCount());
    }