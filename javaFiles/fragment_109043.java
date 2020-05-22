if (includepad) {
    spacing = metrics.bottom - metrics.top;
} else {
    spacing = metrics.descent - metrics.ascent;
}

if (spacingmult != 1 || spacingadd != 0) {
    spacing = (int)(spacing * spacingmult + spacingadd + 0.5f);
}

mBottom = spacing;

if (includepad) {
    mDesc = spacing + metrics.top;
} else {
    mDesc = spacing + metrics.ascent;
}