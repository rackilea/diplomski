settingsContainer.add(new FilterStringPanel("filterStringPanel"){
        private static final long serialVersionUID = 1L;
        @Override
        public void onUpdateFilter(AjaxRequestTarget target) {
            params.setFilterString(getFilterString());
            target.addComponent(dataViewContainer);
            nav.setVisible(dataProvider.size()!=0);
            target.addComponent(nav);
            emptyLabel.setVisible(dataProvider.size()==0);
            target.addComponent(emptyLabel);
        }
    });