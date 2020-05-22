class Result {
    public static Result withWinner(int winner) {
        return new Result(winner);
    }

    public static Result withoutWinner() {
        return new Result(NO_WINNER);
    }

    private static final int NO_WINNER = -1;

    private int winnerId;

    private Result(int id) {
        winnerId = id;
    }

    private int getWinnerId() {
        return winnerId;
    }

    private boolean hasWinner() {
        return winnerId != NO_WINNER;
    }
}