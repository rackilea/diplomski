for( int i = 0; i + LEN_PCM_SAMPLE_BYTES < LEN_PCM_BUFFER; i += LEN_PCM_SAMPLE_BYTES ) {
    // Really rude endian conversion.
    byte bytTemp = a_bytBuffer[i];
    a_bytBuffer[i] = a_bytBuffer[i + 1];
    a_bytBuffer[i + 1] = bytTemp;
 }