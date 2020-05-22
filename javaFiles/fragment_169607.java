boolean controlIsDepressed = false;

list1.getSelectionModel().selectedItemProperty().addListener(
    (observable) -> {
                Scene scene = list1.getScene();
                scene.setOnKeyPressed(e -> {
                    if (e.getCode() == KeyCode.CONTROL) {
                        controlIsDepressed = true;
                    }
                });
                scene.setOnKeyReleased(e -> {
                    if (e.getCode() == KeyCode.CONTROL) {
                        controlIsDepressed = false;
                    }
                });
                // Clear the other list if Ctrl is not being held down
                if (!controlIsDepressed) list2.getSelectionModel().clearSelection();
            });