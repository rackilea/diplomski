public void checkingActivity(byte[] data {
    float[] data_proc = new float[size_data_proc];

    for (int i = 0; i < data.length; i += 2) {
        data_proc[i / 2] = (int) (data[i] << 8) | (int) (data[i+1] & 0x00ff);
    }