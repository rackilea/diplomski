private static final int MAX_FEAT_IMAGE_WIDTH = 600;
private static final int MAX_FEAT_IMAGE_WIDTH = 600;

double featImageWidth = originalImage.getWidth();
double featImageHeight = originalImage.getHeight();

// Sanity check on the input (division by zero, infinity):
if (featImageWidth <= 1 || featImageHeight <= 1) {
    throw new IllegalArgumentException("..." + featureImage);
}

// The scaling factors to reach to maxima on width and height:
double xScale = MAX_FEAT_IMAGE_WIDTH / featImageWidth;
double yScale = MAX_FEAT_IMAGE_HEIGHT / featImageHeight;

// Proportional (scale width and height by the same factor):
double scale = Math.min(xScale, yScale);

// (Possibly) Do not enlarge:
scale = Math.min(1.0, scale);

int finalWidth = Math.min((int) Math.round(scale * featImageWidth), MAX_FEAT_IMAGE_WIDTH);
int finalHeight = Math.min((int) Math.round(scale * featImageHeigth), MAX_FEAT_IMAGE_HEIGHT);