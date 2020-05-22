// max_value gives the maximum allowed value for red, green and blue; that is,
// if red, green and blue are all equal to max_value, you have full white)
change_pixel(int& red, int& green, int& blue, int max_value)
{
  blue = (red+green+blue)/3;
  red = green = (max_value-blue);
}