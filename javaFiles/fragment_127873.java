final int xSrc = min(xSrc, xDst) + 1;
final int xDst = max(xSrc, xDst);
final int ySrc = max(ySrc, yDst) - 1;

if (IntStream.range(0, xDst - xSrc)
    .anyMatch(distance -> board.getActiveChessmanAt(xSrc + distance, ySrc + distance).isAlive())) {
    return false;
}