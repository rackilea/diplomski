lPage.loginProperty().addListener(new ChangeListener<Boolean>(){
        @Override
        public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
            if(lPage.verifyLogin())
                cardLayout.show(panel, "2");
        }
    });