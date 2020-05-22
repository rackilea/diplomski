public static void main(String[] args) throws IOException, ClassNotFoundException {
    Scanner in = new Scanner(System.in);
    float[] floatArray;
    int count = in.nextInt();
    float temp;
    int i = 0;
    floatArray = new float[count];
    while (in.hasNextFloat()) {
        temp = in.nextFloat();
        floatArray[i] = temp;
        i++;
        }
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("glockVert.arr"));
        outputStream.writeObject(floatArray);
}