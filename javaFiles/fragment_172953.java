/**
 * @return the rectangle's width. This does not check for a valid rectangle
 * (i.e. left <= right) so the result may be negative.
 */
public final int width() {
    return right - left;
}

/**
 * @return the rectangle's height. This does not check for a valid rectangle
 * (i.e. top <= bottom) so the result may be negative.
 */
public final int height() {
    return bottom - top;
}