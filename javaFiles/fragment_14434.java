IWorkbenchWindow window = Workbench.getInstance()
            .getActiveWorkbenchWindow();

    if (window instanceof WorkbenchWindow) {
        MenuManager menuManager = ((WorkbenchWindow) window)
                .getMenuManager();

        Menu menu = menuManager.getMenu();
        System.out.println("Menu : " + menu);

        String[] itemIds = { "navigate","Project" };
        for (String itemId : itemIds) {
            IContributionItem item = menuManager.find(itemId);
            if (item != null) {
                item.setVisible(false);
                menuManager.update();
            }
        }
    }