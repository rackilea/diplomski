//access sRGB values (Colors translated from img's ICC profile to sRGB)
System.out.println( "pixel 0,0 value (sRGB): " + Integer.toHexString(img.getRGB(0,0)) ); // getRGB() actually means "getSRGB()"
//access raw raster data, this will give you the uncorrected gray value
//as it is in the image file
Raster raster = image.getRaster();
System.out.println( "pixel 0,0 value (RAW gray value): " + Integer.toHexString(raster.getSample(0,0,0)) );