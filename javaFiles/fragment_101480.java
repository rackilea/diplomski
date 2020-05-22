boolean show = false;
int c = 0;
int num = 0;

void setup() {
  Serial.begin( 9600 );
  Serial.setTimeout( 450 );
  while( ! Serial ) {}
  Serial.println( "Hello world!" );
}

void loop() {
  while( Serial.available() > 0 ) {
    c = Serial.read();
    if( c != '\n' )   // only needed for terminal-programs
      num = num * 10 + (c - '0');
    if( Serial.available() == 0 )
      delay( 5 );  /* 2 */
    show = true;
  }
  if( show ) {
    Serial.println( num );
    Serial.flush();
    num = 0;
    show = false;
  }
}