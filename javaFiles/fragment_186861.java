import ij.IJ;
import ij.gui.ImageRoi;
import ij.gui.Overlay;

imp = IJ.openImage("http://imagej.nih.gov/ij/images/leaf.jpg");
imp2 = IJ.openImage("http://imagej.nih.gov/ij/images/clown.jpg");

ImageRoi roi = new ImageRoi(50, 200, imp2.getProcessor());
roi.setZeroTransparent(false);
roi.setOpacity(0.5);
ovl = new Overlay(roi);

imp.setOverlay(ovl);
imp.show();