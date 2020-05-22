BillingTableRow table ;

tabs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> ov, Tab oldTab, Tab newTab) {
                System.out.println("Tab Selection changed");
                TreeTableView<BillingTableRow> treeTableView = (TreeTableView<BillingTableRow>) newTab.getContent();
                table = treeTableView.getRoot().getValue();
            }
        });