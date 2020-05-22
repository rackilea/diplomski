setOnMousePressed(mouseEvent -> {

    if (mouseEvent.isPrimaryButtonDown()) {
        System.out.println("XXXXXX " + longSignal);
        longSignal = !longSignal;

        longSignalArrow.setVisible(longSignal);   
    }
    if (mouseEvent.isSecondaryButtonDown()) {
        System.out.println("XXXXXX " + shortSignal);
        shortSignal = !shortSignal;

        shortSignalArrow.setVisible(shortSignal);
    }


});