chatTabs.getSelectionModel().selectedItemProperty().addListener(
    new ChangeListener<Tab>() {
        @Override
        public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
            System.out.println("Tab Selection changed");
        }
    }
);