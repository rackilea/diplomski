/**
 * Returns the modifier mask for this event.
 */
public int getModifiers() {
    return modifiers & (JDK_1_3_MODIFIERS | HIGH_MODIFIERS);
}