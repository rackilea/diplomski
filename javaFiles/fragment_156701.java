can.setOnMouseExited(event->{
   gc.clearRect(0, 0, 100, 100);
   gc.setStroke(Color.BLACK);
   gc.strokeRect(0, 0, 100, 100);
   can.setOnMouseExited(null);
});