for (int i=0; i < mat_size && !error; i++) {
    int value = inFromServer.read();
    if (value == -1) {
        error = true; // Actually: end of stream, not error...
    } else {
        mat_arr[i] = (byte) value;
    }
}