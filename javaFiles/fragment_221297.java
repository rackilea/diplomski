private static Mat unsharpMask(Mat input_image, Size size, double sigma){

// Make sure the {input_image} is gray.
  Mat sharpend_image = new Mat(input_image.rows(), input_image.cols(), input_image.type());
  Mat Blurred_image = new Mat(input_image.rows(), input_image.cols(), input_image.type());
  Imgproc.GaussianBlur(input_image, Blurred_image, size, sigma);
  Core.addWeighted(input_image, 2.0D, Blurred_image, -1.0D, 0.0D, sharpened_image);
  return sharpened_image;
}