// Round up width/height to an integer number of macroblocks.
maxPixels = ((maxWidth + 15) / 16) * ((maxHeight + 15) / 16) * 16 * 16;
minCompressionRatio = 2;
// ...
int maxInputSize = (maxPixels * 3) / (2 * minCompressionRatio);
format.setInteger(android.media.MediaFormat.KEY_MAX_INPUT_SIZE, maxInputSize);