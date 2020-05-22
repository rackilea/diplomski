for (int i=0; i<NumOfSamples; i++) {
    for (int j=0; j<NumOfChannels; j++) {
      int sample=samples[i][j];
      byte low = (byte) (sample & 0xff) ;
              byte high = (byte) ((sample & 0xff00 ) >> 8);
              stream[((i*NumOfChannels)+j)*2] = low;    
              stream[(((i*NumOfChannels)+j)*2)+1] = high;         
    }
  }