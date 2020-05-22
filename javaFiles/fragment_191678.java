Iterator<Component> i = tabs.getComponentIterator();
while (i.hasNext()) {
    Component c = (Component) i.next();
    Tab tab = tabs.getTab(c);
    if ("some_caption".equals(tab.getCaption())) {
         // found it
    }
}