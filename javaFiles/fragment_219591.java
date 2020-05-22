private static final float BLOCK_Z_DEPTH = -1; // change to whatever works for you
private int blockCallList;
private boolean regenerateBlockCallList; // set to true whenever you need to update some blocks

public static void init() {
    blockCallList = glGenLists(1);
    regenerateBlockCallList = true;
}

public static void render() {
    if (regenerateBlockCallList) {
        glNewList(blockCallList, GL_COMPILE_AND_EXECUTE);
        drawBlocks();
        glEndList();

        regenerateBlockCallList = false;
    } else {
        glCallList(blockCallList);
    }
}

private static void drawBlocks() {
    // Sorting...

    glPushMatrix();
    glTranslatef(0, 0, BLOCK_Z_DEPTH);

    for (SolidBlock block : xValues.keySet()) {
        List<Integer> blockXValues = xValues.get(block);
        List<Integer> blockYValues = yValues.get(block);

        block.getTexture().bind();
        glBegin(GL_QUADS);
        for(int coordinateIndex = 0; coordinateIndex < blockXValues.size(); coordinateIndex++) {
            int x = blockXValues.get(coordinateIndex);
            int y = blockYValues.get(coordinateIndex);
            addQuad(x,y);
        }
        glEnd();

        blockXValues.clear();
        blockYValues.clear();
    }

    glPopMatrix();

}

private static void addQuad(float x, float y) {
    glTexCoord2f(0, 0);
    glVertex2f(x, y);
    glTexCoord2f(1, 0);
    glVertex2f(x+1, y);
    glTexCoord2f(1, 1);
    glVertex2f(x+1, y+1);
    glTexCoord2f(0, 1);
    glVertex2f(x, y+1);
}