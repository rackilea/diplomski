Bitmap bmp = image.copy(Bitmap.Config.RGB_565, true);
int maxFaces = 5;
FaceDetector faceDetector = new FaceDetector(image.getWidth(),image.getHeight(),maxFaces);
Face[] faces = new Face[maxFaces];
int numberFaces = faceDetector.findFaces(image,faces);
//findFaces should've filled the faces array if it detected any, and you can use it.