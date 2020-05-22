private void readObject(ObjectInputStream ois)
throws ClassNotFoundException,
       IOException {

    ois.defaultReadObject();
    if (gender == null) {
        gender = "unknown";
    }
}