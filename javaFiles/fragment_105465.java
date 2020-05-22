private int row, col; 

    for (col=1;col<=7;col++) {
        for (row=2;row<=31;row++) {
            if (col!=4) {
                ...
                ...
                b.setOnAction(e->{
                    book.addSeat(Seat.genSeat(x, row, col));
                 });
            }
        }
    }