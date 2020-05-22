/** comment these two lines so the token received is the total size */
    tok.nextToken(); // Ignore 1K-blocks
    tok.nextToken(); // Ignore Used
    /** this will now be the total size */
    String freeSpace = tok.nextToken();
    return parseBytes(freeSpace, path);
}