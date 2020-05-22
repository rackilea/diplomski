int rgb = 0xFF0000; //red

//Same but different
//int rgb = Color.RED;

float[] hsv = new float[3];

Color.RGBToHSV(Color.red(rgb),  Color.green(rgb), Color.blue(rgb), hsv);