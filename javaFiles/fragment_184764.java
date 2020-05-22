protected void fillCoolBar(ICoolBarManager coolBar) {
    coolBar.setLockLayout(true);

    IToolBarManager mainToolBar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
    coolBar.add(new ToolBarContributionItem(mainToolBar, "main"));      
    fillMainToolBar(mainToolBar);

    IToolBarManager searchToolBar = new ToolBarManager(SWT.FLAT | SWT.RIGHT);
    ToolBarContributionItem searchBarItem = new ToolBarContributionItem(
            searchToolBar, "search") {
        @Override
        public void fill(CoolBar coolBar, int index) {
            super.fill(coolBar, index);
            // change the layout of the cool-bar to have the search
            // controls on the right side
            GridLayout coolBarLayout = new GridLayout(2, false);
            coolBarLayout.marginHeight = 0;
            coolBarLayout.marginWidth = 0;
            coolBarLayout.horizontalSpacing = 20;
            coolBarLayout.verticalSpacing = 0;
            coolBarLayout.marginLeft = 10;
            coolBar.setLayout(coolBarLayout);
            GridData mainGridData = new GridData(SWT.LEFT, SWT.CENTER, true,
                    false);
            GridData searchGridData = new GridData(SWT.RIGHT, SWT.CENTER,
                    false, false);
            coolBar.getItem(0).getControl().setLayoutData(mainGridData);
            coolBar.getItem(1).getControl().setLayoutData(searchGridData);
        }
    };
    coolBar.add(searchBarItem);
    searchToolBar.add(new SearchTextControl());
    searchToolBar.add(searchAction);
}