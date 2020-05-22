private static Mat clahe(Mat image, int ClipLimit, Size size){
  CLAHE clahe = Imgproc.createCLAHE();
  clahe.setClipLimit(ClipLimit);
  clahe.setTilesGridSize(size);
  Mat dest_image = new Mat();
  clahe.apply(image, dest_image);
  return dest_image;
}