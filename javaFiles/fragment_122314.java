/**
 * converts this number to an arbitrary radix.
 * @param radix the target radix, {@code 1 < radix < BASE}.
 * @return the digits of this number in the base-radix system,
 *     in big-endian order.
 */
public int[] convertTo(int radix)
{
    if(radix <= 1 || BASE <= radix) {
        throw new IllegalArgumentException("radix " + radix +
                                           " out of range!");
    }