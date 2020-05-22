if (PlainW >= 612) {
    xDiff = PlainW - 612;
} else if (PlainW < 612) {
    xDiff = 612 - PlainW;
}
xScale = PlainW / 612;
yDiff = Math.abs(PlainH - 792);
yScale = PlainH / 792;