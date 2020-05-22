/**
 * @see Sequencer#remainingCapacity()
 */
@Override
public long remainingCapacity()
{
    long consumed = Util.getMinimumSequence(gatingSequences, cursor.get());
    long produced = cursor.get();
    return getBufferSize() - (produced - consumed);
}