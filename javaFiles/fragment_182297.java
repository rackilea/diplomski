for (String line : lines) {
    if (!line.contains("%")) continue;

    // Find the index of "received, "
    int index1 = line.indexOf("received, ");

    // Find the index of "%"
    int index2 = line.indexOf("%");

    String percent = line.substring(index1 + "received, ".length(), index2);
    // do what you will
}