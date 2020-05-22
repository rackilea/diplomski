public List<Widget> compriseWidgets(final List<Fidget> fidgetList) {
    final List<Widget> widgets = new ArrayList<Widget>();
    final ListIterator<Fidget> fidgets = fidgetList.listIterator();

    while (addWidget(widgets, fidgets)) { /* empty */ }

    return widgets;
}    

private boolean addWidget(final List<Widget> widgets, final ListIterator<Fidget> fidgets) {
    if (fidgets.hasNext()) {
        final Fidget firstFidget = fidgets.next();
        final Widget currentWidget = new Widget();

        widgets.add(currentWidget);
        currentWidget.setFizz(firstFidget.getFizz());
        currentWidget.setBuzz(firstFidget.getFoo().length());
        currentWidget.getCollaborators().add(firstFidget);

        while (fidgets.hasNext()) {
            final nextFidget = fidgets.next();

            if (currentWidget.getFizz().equals(nextFidget.getFizz())) {
                currentWidget.getCollaborators().add(nextFidget);
            } else {
                fidgets.previous();
                return true;
            }
        }
    }

    return false;
}