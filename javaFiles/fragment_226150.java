try (
    // open the resource here
) {
    String line;
    while ((line = reader.readLine()) != null)
        showMainMenu(line);
}