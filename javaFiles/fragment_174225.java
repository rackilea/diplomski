BitmapFactory.Options opt = new BitmapFactory.Options();
opt.inPreferredConfig= Bitmap.Config.ARGB_8888;
Bitmap bmp=BitmapFactory.decodeStream(entity.getContent(),null,opt);
int W=bmp.getWidth();
int H=bmp.getHeight();
int px;
for (int i = 0; i < H; i++)
    for (int j = 0; j < W; j++)
    {
          px= bmp.getPixel(j, i)&0x0000ffff;//in px you will find a value between 0 and 65535
          ...
    }