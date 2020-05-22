/**
 * Sets values for a absolute repositioning of the Element.
 * The coordinates specified correspond to the
 * bottom-left corner of the element and it grows upwards.
 * Also has as a side effect that the Element's {@link Property#POSITION} is changed to
 * {@link LayoutPosition#FIXED fixed}.
 *
 * @param left   horizontal position of the bottom-left corner on the page
 * @param bottom vertical position of the bottom-left corner on the page
 * @param width  a floating point value measured in points.
 * @return this Element.
 */
public T setFixedPosition(float left, float bottom, float width)

/**
 * Sets the height property a block element as a point-value.
 *
 * @param height a floating point value for the new height
 * @return the block element itself.
 */
public T setHeight(float height)