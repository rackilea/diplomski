public List<Widget> compriseWidgets(final List<Fidget> fidgetList) {
    final List<Widget> widgets = new ArrayList<Widget>();
    final Widget[] currentWidget = new Widget[] {null};

    for (final Fidget fidget : fidgetList) {
        if (currentWidget[0] == null || 
                !currentWidget[0].getFizz().equals(fidget.getFizz())) {

            currentWidget[0] = new Widget();
            widgets.add(currentWidget);
            currentWidget.setFizz(fidget.getFizz());
            currentWidget.setBuzz(fidget.getFoo().length());
        }

        currentWidget.getCollaborators().add(fidget);
    }

    return widgets;
}