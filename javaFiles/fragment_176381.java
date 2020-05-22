Map<String,Histogram> histograms = new HashMap<String,Histogram>();
histograms.put("PropertyValue1", histogram1);
histograms.put("PropertyValue2", histogram2);

String desiredHistogram = silderBox.getProperty("VALUE");
Histogram histogramToUse = histograms.get(desiredHistogram);
histogramToUse.getSum(); // do whatever you need to with this