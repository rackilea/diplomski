String str = seatMap.getAvailable().getSeats().toString();
    // So str = "[A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23, A24, A25, A26, A27, A28, A29, A30, A31, A32]";

    str.replace("[", "");
    str.replace("]", "");
    String[] availableSeats = str.split(", ");
    for (String seat: availableSeats) {
        if (seat.equals("A1"))
        {
            Log.d("SUCCESS", "Found A1");
            // Do sometthing
            // seat.status = HallScheme.SeatStatus.FREE;

            break;
        }
    }