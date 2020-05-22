public boolean isValid() {
    boolean isValid = true;

    for (int i = 0; isValid && i < this.getClass().getFields().length; ++i) {
        if (this.getClass().getFields()[i].equals(null)) {
            isValid = false;
        }
    }

    return isValid;
}