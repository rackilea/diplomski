static INT32 bitsArray[] = { 8, 16};
 ....
 #define BITS_COUNT sizeof(bitsArray)/sizeof(INT32)
 ....
     for (rateIndex = 0; rateIndex < SAMPLERATE_COUNT; rateIndex++) {
    for (channelIndex = 0; channelIndex < CHANNELS_COUNT; channelIndex++) {
        for (bitIndex = 0; bitIndex < BITS_COUNT; bitIndex++) {
            DAUDIO_AddAudioFormat(creator, bitsArray[bitIndex],