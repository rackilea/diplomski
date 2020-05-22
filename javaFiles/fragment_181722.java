for (int i = 0; i < n; i++)
{ 
         v1[i] = ((float)i-(float)(n-1f)/2f)*
             (float)Math.Sin(0.001f* 50f*2f*Math.PI*(float)i);
                               ^      ^  ^                 ^
                               |      |  |                 |
                               |      F  |                 |
                           sampling      2xPi constant   sample bin
                           rate(simulation)
}