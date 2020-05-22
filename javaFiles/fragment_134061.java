644       // Package private constructor which shares value array for speed.
  645       String(int offset, int count, char value[]) {
  646           this.value = value;
  647           this.offset = offset;
  648           this.count = count;
  649       }