int getOffset(int line) {
    int listIndex = line >> 20; // one list entry per 1M lines
    int arrayIndex = (line >> 10) & 1023; one array entry per 1k lines
    int remaining = line & 1023; // lines to skip

    // TODO: handling of index bounds
    int offset = offsets.get(listIndex)[arrayIndex];
    **seek to offset
    **skip remaining lines
}