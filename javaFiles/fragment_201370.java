daysSlider.valueProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue arg0, Object arg1, Object arg2) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
              priceTextField.textProperty().setValue(
              String.valueOf((int) daysSlider.getValue() * baseCost.get(0) ));
            }
        };

        Handler handler = new Handler();
        //Run the runnable after 3000 milliseconds or 3 seconds.
        handler.postDelayed(runnable, 3000);

    }

});