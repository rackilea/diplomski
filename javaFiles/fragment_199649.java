Bitmap other = ...;
//create a blank bitmap
Bitmap newBitmap = Bitmap.createBitmap(other.getWidth(),
                      other.getHeight(), other.getConfig());

//copy some pixels from 'other'
int x=14,y=45,width=23,height=56;
int [] pixels = new int[width * height];
other.getPixels(pixels, 0, width, x, y, width, height);
newBitmap.setPixels(pixels, 0, width, x, y, width, height);