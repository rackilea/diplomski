// this line will overwrite your imgMain, 
// the type will be CV_8UC4, regardless, what you said before.
Utils.bitmapToMat(pimage, imgMain);

// so, convert to float:
imgMain.convertTo(imgMain, CvType.CV_32FC4);

// now add float images, to avoid precision loss:
scaleAdd(imgMain, 0.1, imgFin, imgFin);