/* The raw char array from c is now read into the byte[] `bytes` in java */
DataInputStream stream = new DataInputStream(new ByteArrayInputStream(bytes));

int dim_x; int dim_y;
double[][] data;

try {   
    dim_x = stream.readInt();
    dim_y = stream.readInt();
    data = new double[dim_x][dim_y];
    for(int i = 0; i < dim_x; ++i) {
        for(int j = 0; j < dim_y; ++j) {
            data[i][j] = stream.readDouble();
        }
    }

    System.out.println("Client:");
    System.out.println("Dimensions: "+dim_x+" x "+dim_y);
    System.out.println("Data:");
    for(int i = 0; i < dim_x; ++i) {
        for(int j = 0; j < dim_y; ++j) {
            System.out.print(" "+data[i][j]);
        }
        System.out.println();
    }


} catch(IOException e) {
    System.err.println("Error reading input");
    System.err.println(e.getMessage());
    System.exit(1);
}