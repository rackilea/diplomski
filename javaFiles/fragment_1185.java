// Queue up the scaling operation (or any other op)
Future<BufferedImage> result = AsyncScalr.resize(origImage, 125);

/*
 * You can do other work here that doesn't need 'result', like making
 * DB calls, cleaning up temp files or anything else you might need to
 * do.
 */

// Now we are all done and need the resulting image, so we wait for it.
BufferedImage scaledImage = result.get();

// Do something with the image...