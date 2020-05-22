private void readObject(java.io.ObjectInputStream in) {
    super.readObject(in);
    // paws used to be an integer
    if (pawsLong == 0 && paws != 0) {
        pawsLong = paws;
    }
}