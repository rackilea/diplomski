private SampleModel sampleModel;

public int[][] compute(File file)
{
    ...
    sampleModel = raster.getSampleModel();
    ...
}

public java.awt.Image getImage(int pixels[][])
{
    ...
    WritableRaster raster= Raster.createWritableRaster(sampleModel, new Point(0,0));
    for(int i=0;i<w;i++)
    {
        for(int j=0;j<h;j++)
        {
            raster.setSample(i,j,0,pixels[i][j]);
        }
    }

    BufferedImage image=new BufferedImage(w,h,BufferedImage.TYPE_BYTE_GRAY);
    image.setData(raster);
    ...
}