private void buttonAction(){
        if(!checkFields()){
            Alert message=new Alert(        Alert.AlertType.WARNING);
            message.setHeaderText("Text field empty");
            message.setContentText("One of the text fields is empty");
            message.showAndWait();
            return;
        }

        //continue the method
    }