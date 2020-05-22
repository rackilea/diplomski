public void shiftRight(int index, int k)
    throws ArrayIndexOutOfBoundsException
{
    int length = this.list.size();
    // Note: index cannot be equal to length. You were testing for >.
    if ((index < 0) || (index >= length))
    {
        throw new ArrayIndexOutOfBoundsException('out of range index: ' + index);
    }
    int shift = k % length; // Use modulo arithmetic to determine a shift in the range [0..length).
    if (shift == 0)
    {
         return; // No change, we're done.
    }
    int newIndex = (index + shift) % length; // Calculate where to move to, again using modulo arithmetic, to get the loop around.
    int element = this.list.remove(index);
    this.list.add(newIndex, element);
}