Mat image = new Mat(roi.size(), CvType.CV_8UC1);

// unsure of syntax for your platform here... but something like ...
Bitmap newBitmap = Bitmap.createBitmap(image.cols(), image.rows(), 
                                           Bitmap.Config.ARGB_8888);

// now copy the image
Utils.matToBitmap(image, newBitmap);