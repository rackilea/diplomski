try (FileOutputStream fout = new FileOutputStream(filename);
     BufferedOutputStream bout = new BufferedOutputStream(fout);
     DataOutputStream dout = new DataOutputStream(bout)) {
    // Note: Body here is as per original question. It won't compile, but
    // we don't know what was expected.
    for (int i=0; i < matrixApp; i++){
        dout.writeInt(matrixApp[][]);
    }
}