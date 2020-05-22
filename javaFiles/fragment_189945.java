ImagePlus imp = WindowManager.getCurrentImage();
double lineLength = 0;
Roi roi = imp.getRoi();

if (roi != null && roi.isLine()) {
    lineLength = roi.getLength();
}