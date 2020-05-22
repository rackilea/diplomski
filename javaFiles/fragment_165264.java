float[] data = {
   // x,   y,   z,    r,  g,  b
    -1f,  1f,  0f,   1f, 0f, 0f,// Left  top   , red  , ID: 0
    -1f, -1f,  0f,   0f, 1f, 0f,// Left  bottom, blue , ID: 1
     1f, -1f,  0f,   0f, 0f, 1f,// Right bottom, green, ID: 2
     1f,  1f,  0f,   1f, 1f, 1f // Right left  , white, ID: 3
};

byte[] indices = {       
    0, 1, 2,// Left bottom triangle
    2, 3, 0 // Right top triangle
};