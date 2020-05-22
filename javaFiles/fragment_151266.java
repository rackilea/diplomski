public void setFont(Font f) {
    super.setFont(f);
    if (inputField != null) {
        inputField.setFont(f);
    }
    if (send != null) {
        send.setFont(f);
    }

    Dimension size = getSizeFromFont(); 
    // Dimension based on getFont()'s height

    if (send != null) {
        send.setPreferredSize(size);
    }
    if (inputField != null) {
        inputField.setPreferredSize(size);
    }
}