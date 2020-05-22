/**
 * Indicates whether or not this view's layout is right-to-left. This is resolved from
 * layout attribute and/or the inherited value from the parent
 *
 * @return true if the layout is right-to-left.
 *
 * @hide
 */
@ViewDebug.ExportedProperty(category = "layout")
public boolean isLayoutRtl() {
    return (getLayoutDirection() == LAYOUT_DIRECTION_RTL);
}