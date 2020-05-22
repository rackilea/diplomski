/**
 *  Decodes the current packet and sends it to the audio output line.
 */
private void decodeCurrentPacket()
{
    int samples;

    // Check that the packet is a audio data packet etc.
    if(jorbisBlock.synthesis(joggPacket) == 0)
    {
        // Give the block to the DspState object.
        jorbisDspState.synthesis_blockin(jorbisBlock);
    }

    // We need to know how many samples to process.
    int range;

    /*
     * Get the PCM information and count the samples. And while these
     * samples are more than zero...
     */
    while((samples = jorbisDspState.synthesis_pcmout(pcmInfo, pcmIndex))
        > 0)
    {
        // We need to know for how many samples we are going to process.
        if(samples < convertedBufferSize)
        {
            range = samples;
        }
        else
        {
            range = convertedBufferSize;
        }

        // For each channel...
        for(int i = 0; i < jorbisInfo.channels; i++)
        {
            int sampleIndex = i * 2;

            // For every sample in our range...
            for(int j = 0; j < range; j++)
            {
                /*
                 * Get the PCM value for the channel at the correct
                 * position.
                 */
                int value = (int) (pcmInfo[0][i][pcmIndex[i] + j] * 32767);

                /*
                 * We make sure our value doesn't exceed or falls below
                 * +-32767.
                 */
                if(value > 32767)
                {
                    value = 32767;
                }
                if(value < -32768)
                {
                    value = -32768;
                }

                /*
                 * It the value is less than zero, we bitwise-or it with
                 * 32768 (which is 1000000000000000 = 10^15).
                 */
                if(value < 0) value = value | 32768;

                /*
                 * Take our value and split it into two, one with the last
                 * byte and one with the first byte.
                 */
                convertedBuffer[sampleIndex] = (byte) (value);
                convertedBuffer[sampleIndex + 1] = (byte) (value >>> 8);

                /*
                 * Move the sample index forward by two (since that's how
                 * many values we get at once) times the number of channels.
                 */
                sampleIndex += 2 * (jorbisInfo.channels);
            }
        }

        // Write the buffer to the audio output line.
        outputLine.write(convertedBuffer, 0, 2 * jorbisInfo.channels
            * range);

        // Update the DspState object.
        jorbisDspState.synthesis_read(range);
    }
}