// Example values
int r = 255; // 0xFF
int g = 1;   // 0x01
int b = 15;  // 0x0F

// go back to original form:
                      //    A  R  G  B
int color = r << 16;  // 0x00.FF.00.00
color += g << 8;      // 0x00.FF.01.00
color += b;           // 0x00.FF.01.0F

// just add back the alpha if it is going to be full on
color = += 255 << 24; // 0xFF.FF.01.0F