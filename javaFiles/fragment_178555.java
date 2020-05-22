GridPane gPane = new GridPane();
     gPane.setSnapToPixel(true);
     gPane.setStyle("-fx-background-color: DARKGREY; -fx-padding: 1;"
                    +"-fx-hgap: 1; -fx-vgap: 1;");

     for(int i=0; i<mainApp.getItemList().size(); i++){ // rows
         for(int j=0; j<mainApp.getItemList().get(0).size(); j++){ //columns

             Color color = mainApp.getItemList().get(i).get(j).getValue().getDisplayColor();
                int r = (int) (color.getRed() * 255);
                int g = (int) (color.getGreen() * 255);
                int b = (int) (color.getBlue() * 255);

             Rectangle rect = new Rectangle(5,5);

             rect.setStyle("-fx-fill: rgb(" + r + "," + g + "," + b + ");");
             gPane.add(rect, j, i);
         }
     }
        Scene scene = new Scene(gPane);
        WritableImage image = gPane.snapshot(new SnapshotParameters(), null);