for (Map.Entry<String, BitMatrix> e : getQrMatrixes().entrySet()) {
    boolean[][] b = new boolean[e.getValue().getHeight()][e.getValue().getWidth()];
    for (int j = 0; j < e.getValue().getHeight(); j++) {
        for (int k = 0; k < e.getValue().getWidth(); k++) {
            b[j][k] = e.getValue().get(j, k);
        }
    }
    qrMatrixBooleanArrays.put(e.getKey(), b);
}