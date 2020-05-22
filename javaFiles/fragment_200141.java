try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
    // Write stuff...

    try (BufferedWriter metaBW = new BufferedWriter(new FileWriter(metaFile))) {
        // Write meta data
    }
} catch (IOException ex) {
    ex.printStackTrace();
}