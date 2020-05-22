@FXML
private JFXListView li_se;

int d;

@FXML
private void Services(ActionEvent e) {
    try {
        li_se.getItems().clear();
        for (int i = 0; i < R.OffrirService().size(); i++) {
            JFXCheckBox s = new JFXCheckBox(R.OffrirService().get(i));
            s.selectedProperty().addListener((obs, wasOn, isNowOn) -> {
                if (wasOn == false) {
                    //if checked do something
                    d++;
                        if (d == R.OffrirService().size()) {
                            //if all checked do something
                        }
                } else {
                    //if unchecked do something
                    d--;
                        if (d == 0) {
                            //if all unchecked do something
                        }
                //System.out.println(s.getText() + " changed on state from " + wasOn + " to " + isNowOn);
            });
            li_se.getItems().add(s);
    }
}