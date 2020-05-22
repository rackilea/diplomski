int color = 0xFFFF0000;
float[] hsv = new float[3];
Color.colorToHSV(color, hsv);
hsv[2] = 0.2f;
color = Color.HSVToColor(hsv);
int[] rgb = new int[3];
MyColor.colorToRGB(color, rgb); // Your custom method
// The rgb array now contains your RGB colors.