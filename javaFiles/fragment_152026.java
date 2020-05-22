Dialog<Etudiant> dialog = new Dialog<>();
    ...
    GridPane content = Analysateur.analyserChamp(test); //Keep the content accesible
    ...
    dialog.getDialogPane().setContent(content);
    ...
    dialog.setResultConverter(button -> { //Convert the result
        Etudiant result = new Etudiant();
        for (Node child : content.getChildren()) { //Iterate over the GridPane children
            if (child instanceof TextField) {
                String attribute = ((TextField)child).getUserData();
                String value = ((TextField)child).getTest();
                //Set the value in the result attribute via instrospection
            }
            if (child instanceof ComboBox) {
                //Do the same with combos
            }
        }
    });