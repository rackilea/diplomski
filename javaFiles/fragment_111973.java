if (PlainW >= 612) {
    xDiff = PlainW - 612;
    xScale = PlainW / 612;
    if (PlainH < 792) {
        yDiff = 792 - PlainH;
    } else if (PlainH == 792) {
        yDiff = 792 - PlainH;
    } else if (PlainH > 792) {
        yDiff = PlainH - 792;
    }
} else if (PlainW < 612) {
    xDiff = 612 - PlainW;
    xScale = PlainW / 162;
    if (PlainH < 792) {
        yDiff = 792 - PlainH;
    } else if (PlainH == 792) {
        yDiff = 792 - PlainH;
    } else if (PlainH > 792) {
        yDiff = PlainH - 792;
    }
}
yScale = PlainH / 792;