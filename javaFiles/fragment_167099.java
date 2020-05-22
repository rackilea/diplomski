int interval = 44100; // 1 beat per second, by default
int count = 0;
void setBPM( float bpm ) {
    interval = ( bpm / 60 ) * 44100 ;
}
void generateMetronomeSamples( short[] s ) {
    for( int i=0; i<s.length; ++i ) {
       s = 0;
       ++count;
       if( count == 0 ) {
          s = Short.MAX_VALUE;
       }
       if( count == interval ) {
          count = 0;
       }
    }
}