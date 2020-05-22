final MPart part = getSite().getService(MPart.class);
    String menuLocation = "toolbar:org.acme.menu";

    if (menuService instanceof WorkbenchMenuService) {
        ((WorkbenchMenuService) menuService).populateContributionManager(part, manager, menuLocation);
    } else if (menuService instanceof SlaveMenuService) {
        ((SlaveMenuService) menuService).populateContributionManager(part, manager, menuLocation);
    } else
        throw new UnsupportedOperationException("Do not know how to handle " + menuService); //$NON-NLS-1$