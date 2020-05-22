grid_map[19][19].hoverProperty().addListener((observable, oldValue, show) -> {
    if (show) {

         double x = grid_map[19][19].getLayoutX();
         double y = grid_map[19][19].getLayoutY();
         double w = temporary.prefWidth(-1);
         double h = temporary.prefHeight(w);
         temporary.resizeRelocate(x, y, w, h);
         temporary.setVisible(true);
    } else {
          temporary.setVisible(false);
    }

});