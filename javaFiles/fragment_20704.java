public void imageToGrayScale()
 {
  double[][] matrix1 = {{ 1./3, 1./3, 1./3, 0 }};

  ParameterBlock pb = new ParameterBlock();
  pb.addSource(image);
  pb.add(matrix1);

  PlanarImage dst = (PlanarImage) JAI.create("bandCombine",pb,null);



  BufferedImage img = dst.getAsBufferedImage();
  display(img);

 }