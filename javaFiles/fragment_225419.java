import ij.IJ;
import histogram2.HistogramMatcher;

// get first image
imp1 = IJ.openImage("http://imagej.nih.gov/ij/images/bridge.gif");
// get second image
imp2 = IJ.openImage("http://imagej.nih.gov/ij/images/boats.gif");

ip1 = imp1.getProcessor();
ip2 = imp2.getProcessor();

hist1 = ip1.getHistogram();
hist2 = ip2.getHistogram();

matcher = new HistogramMatcher();
newHist = matcher.matchHistograms(hist1, hist2);

ip1.applyTable(newHist);
imp1.setProcessor(ip1);

imp1.show();
imp2.show();

// show the histograms of both images
IJ.run(imp1, "Histogram", "");
IJ.run(imp2, "Histogram", "");