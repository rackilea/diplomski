double[] elevations={238.27,242.1301,222,1};
int[] pixels = doublesToInts(elevations);

    //encoding
Bitmap bmp=Bitmap.createBitmap(2, 2, Config.ARGB_8888);
bmp.setPixels(pixels, 0, 2, 0, 0, 2, 2);
File file=new File(getCacheDir(),"bitmap.png");
try {
    FileOutputStream fos = new FileOutputStream(file);
    bmp.compress(CompressFormat.PNG, 100, fos);
    fos.close();
} catch (IOException e) {
    e.printStackTrace();
}

//decoding
Bitmap out=BitmapFactory.decodeFile(file.getPath());
if (out!=null)
{   
    int [] outPixels=new int[out.getWidth()*out.getHeight()];
    out.getPixels(outPixels, 0, out.getWidth(), 0, 0, out.getWidth(), out.getHeight());
    double[] outElevations=intsToDoubles(outPixels);
}

static int[] doublesToInts(double[] elevations)
{
    int[] out=new int[elevations.length];
    for (int i=0;i<elevations.length;i++)
    {
        int tmp=(int) (elevations[i]*1000000);          
        out[i]=0xFF000000|tmp>>8;
    }
    return out;
}
static double[] intsToDoubles(int[] pixels)
{
    double[] out=new double[pixels.length];
    for (int i=0;i<pixels.length;i++)
        out[i]=(pixels[i]<<8)/1000000.0;
    return out;
}