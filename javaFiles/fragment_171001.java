Scanner blockScanner = new Scanner(resource);

Block currentBlock = null;
while (blockScanner.hasNextLine()) {
    String line = blockScanner.nextLine();
    String[] tokens = line.split("\\s+");

    // NEW_BLOCK == "$"
    if (tokens[0].equals(NEW_BLOCK)) {
        currentBlock = createBlockFromTokens(tokens);
        blocks.add(currentBlock);
    } else if (currentBlock != null) {
        currentBlock.addLine(createLineFromTokens(tokens));
    }
}