for (String line : lines) {
    if (!line.contains("time=")) continue;
    // Find the index of "time="
    int index = line.indexOf("time=");

    String time = line.substring(index + "time=".length());
    // do what you will
}