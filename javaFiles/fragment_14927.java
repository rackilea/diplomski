try {
    reader.wait();
} catch (InterruptedException ie) {
    ie.printStackTrace();
}
reader.close();