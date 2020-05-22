for(int i=0;i<30;i++){
    Node seat = seats[i];
    seat.setOnMouseClicked(e->{
        seat.setEffect(lighting);       
    });
}