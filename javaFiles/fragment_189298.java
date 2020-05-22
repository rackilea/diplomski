import java.util.BitSet;

/**
 * Creates a new BitSet of the specified length
 * with the {@code len} leftmost bits set to {@code true}.
 *
 * @param totalBits The length of the resulting {@link BitSet}.
 * @param len       The amount of leftmost bits to set.
 * @throws IllegalArgumentException If {@code len > totalBits} or if any of the arguments is negative
 */
public static BitSet leftmostBits(int totalBits, int len)
{
    if (len > totalBits)
        throw new IllegalArgumentException("len must be smaller or equal to totalBits");
    if (len < 0 || totalBits < 0)
        throw new IllegalArgumentException("len and totalBits must both be positive");
    BitSet bitSet = new BitSet(totalBits);
    bitSet.set(0, len);
    return bitSet;
}