public String toString() {
    final String EOL = System.getProperty("line.separator");
    final int EOL_LENGTH = EOL.length();
    StringBuilder output = new StringBuilder(image.length() + EOL_LENGTH * height);
    output.append(image);
    for (int i = 0; i < height; i++) {
        output.insert(i*(width + EOL_LENGTH) + width, EOL);
    }
    return output.toString();  
}