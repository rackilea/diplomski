public class MidiEvent
    {
    /**Number of time units to wait until this message should be sent.
    */
    public int time_delta;

    /**First status byte.
    */
    public byte byte_0;

    /**Second status byte.
    */
    public byte byte_1;

    /**Third status byte.
    */
    public byte byte_2;
    }