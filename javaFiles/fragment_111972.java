if (PlainW >= 612) { //x is over or equal
    xDiff = PlainW - 612;
    xScale = PlainW / 612;
    if (PlainH < 792) { //y is under
        yDiff = 792 - PlainH;
        yScale = PlainH / 792;
    } else if (PlainH == 792) { //y is equal
        yDiff = 792 - PlainH;
        yScale = PlainH / 792;
    } else if (PlainH > 792) { //y is over
        yDiff = PlainH - 792;
        yScale = PlainH / 792;
    }
} else if (PlainW < 612) { //x is under
    xDiff = 612 - PlainW;
    xScale = PlainW / 162;
    if (PlainH < 792) { //y is under
        yDiff = 792 - PlainH;
        yScale = PlainH / 792;
    } else if (PlainH == 792) { //y is equal
        yDiff = 792 - PlainH;
        yScale = PlainH / 792;
    } else if (PlainH > 792) { //y is over
        yDiff = PlainH - 792;
        yScale = PlainH / 792;
    }
}