// Get masked from the drawing we made
Mat mask = imageView.mask;

// Create ROI
Rect bounding_box = new Rect(10, 10, mask.cols()-10,
        mask.rows()-10);

// Get original image and convert from RGBA to RGB
Mat original_image = new Mat();
Utils.bitmapToMat(imageView.original_bitmap, original_image);
Imgproc.cvtColor(original_image, original_image, Imgproc.COLOR_RGBA2RGB);

// Do extraction
Imgproc.grabCut(original_image, mask, bounding_box, new Mat(), new Mat(),
        NUM_ITERATIONS, Imgproc.GC_INIT_WITH_MASK);

// New mask to hold ONLY what was marked GC_PR_FGD by grabcut on our mask.
Mat probable_fgd_mask = new Mat();
Core.compare(mask, new Scalar(Imgproc.GC_PR_FGD), probable_fgd_mask, Core.CMP_EQ);

// Reusing mask variable, store into mask only what was marked as GC_FGD
// inside of mask.
Core.compare(mask, new Scalar(Imgproc.GC_FGD), mask, Core.CMP_EQ);

// Combine both masks so that we have GC_FGD + GC_PR_FGD
Core.add(probable_fgd_mask, mask, mask);

// We will store the foreground into an all-black Mat,
Mat foreground = new Mat(original_image.size(), CvType.CV_8UC1,
        new Scalar(0, 0, 0));

// Copy the original image to 'foreground', but mask it with our newly created
// mask (GC_FGD + GC_PR_FGD)
original_image.copyTo(foreground, mask);