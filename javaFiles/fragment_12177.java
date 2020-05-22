glNewList(heightmapDisplayList, GL_COMPILE);
for (int z = 0; z < data.length - 1; z++) {
    glBegin(GL_TRIANGLE_STRIP);
    // The t texture coordinate for z and z + 1
    float t0 = (float)z / (data.length - 1); // t0 in [0,1]
    float t1 = (float)(z + 1) / (data.length - 1); // t1 in [0,1]
    for (int x = 0; x < data[z].length; x++) {
        // The s texture coordinate for x
        float s = (float)x / (data[z].length - 1); // s in [0, 1]
        glTexCoord2f(s, t0);
        glVertex3f(x, data[z][x], z);
        glTexCoord2f(s, t1); 
        glVertex3f(x, data[z + 1][x], z + 1);
    }
    glEnd();
}
glEndList();