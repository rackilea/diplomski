(...)
imgResized = preProcessImage(img);
Size dsize = new Size(20,30);
Imgproc.resize(imgResized, imgResized, dsize);
imgResized.convertTo(imgResized, CvType.CV_32FC1);
imgResized = imgResized.reshape(1, 1);
train_samples.push_back(imgResized);
(...)