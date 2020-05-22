Mat A = Highgui.imread(image_addr); //"image_addr" is the address of the image
Mat C = A.clone();
A.convertTo(A, CvType.CV_64FC3); // New line added. 
int size = (int) (A.total() * A.channels());
double[] temp = new double[size]; // use double[] instead of byte[]
A.get(0, 0, temp);
for (int i = 0; i < size; i++)
   temp[i] = (temp[i] / 2);  // no more casting required.
C.put(0, 0, temp);