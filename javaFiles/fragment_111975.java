if (PlainW >= 612) {
    xDiff = PlainW - 612;
    xScale = PlainW / 612;
    yDiff = Math.abs(PlainH - 792);
} else if (PlainW < 612) {
    xDiff = 612 - PlainW;
    xScale = PlainW / 162;
    yDiff = Math.abs(PlainH - 792);
}
yScale = PlainH / 792;