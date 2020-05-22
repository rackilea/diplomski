x.addListener(new ChangeListener<String>(){

        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            String outcome = "";
            //determine outcome depending on newValue.intern();
            outcomeLabel.setText(outcome);
        }           

});