override fun updateDrawState(ds: TextPaint) {
    super.updateDrawState(ds)

    ds.color = color
    ds.textSize = size.toFloat()
    ds.letterSpacing = letterSpacing

    // here you might want to play with a specific value or ds.ascent/ds.descent..
    ds.baselineShift += 12
}