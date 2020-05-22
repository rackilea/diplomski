/**
 * Allocates a new block of native memory, of the given size in bytes.  The
 * contents of the memory are uninitialized; they will generally be
 * garbage.  The resulting native pointer will never be zero, and will be
 * aligned for all value types.  Dispose of this memory by calling {@link
 * #freeMemory}, or resize it with {@link #reallocateMemory}.
 *
 * @throws IllegalArgumentException if the size is negative or too large
 *         for the native size_t type
 *
 * @throws OutOfMemoryError if the allocation is refused by the system
 *
 * @see #getByte(long)
 * @see #putByte(long, byte)
 */
public native long allocateMemory(long bytes);