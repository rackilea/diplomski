final ListView<CCSubscription> tables = new ListView<CCSubscription>(
            "tables", getCustomer().getSubscriptions()) {
        @Override
        protected void populateItem(ListItem<CCSubscription> item) {
            ListView<ResourceBalance> resBalTable = new ListView<ResourceBalance>("listview", Arrays.asList(item.getModel().getObject().getResourceBalances())) {

                @Override
                protected void populateItem(ListItem<ResourceBalance> item) {
                    ResourceBalance bal = item.getModelObject();
                    item.add(new Label("resource", bal.getResource().getName()));
                    item.add(new Label("balance", bal.getBalance()+""));
                }
            };
            item.add(resBalTable);
        }
    };

    add(tables);