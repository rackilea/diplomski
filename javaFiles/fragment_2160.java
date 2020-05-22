public int[] findSeats(int row) {

        final int[] avSeats = new int[seats[row].length];
        IntStream.range(0, seats[row].length).filter(seatNo -> !seats[row][seatNo]).forEach(seatNo -> avSeats[seatNo] = 1);
        return avSeats;

    }