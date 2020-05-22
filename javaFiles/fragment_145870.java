private int calcLength(GlyphLayout glyphLayout) {

    int length = 0;
    for(GlyphLayout.GlyphRun run : glyphLayout.runs) {
        length += run.glyphs.size;
    }
    return length;
}