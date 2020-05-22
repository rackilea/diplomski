private Result isThereAWinner() {
    // if a winner is found
    return Result.withWinner(winnersID);
    // else
    return Result.withoutWinner();
}