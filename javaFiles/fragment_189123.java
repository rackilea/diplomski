public void menuAboutToShow(final IMenuManager manager) {

        final Action bAction = new Action("B") {};
        final Action cAction = new Action("C") {};
        final Action dAction = new Action("D") {};
        final Action eAction = new Action("E") {};
        final Action fAction = new Action("F") {};

        final MenuManager subMenu = new MenuManager("A");

        subMenu.add(dAction);
        subMenu.add(eAction);
        subMenu.add(fAction);

        manager.add(subMenu);

        manager.add(bAction);
        manager.add(cAction);
    }