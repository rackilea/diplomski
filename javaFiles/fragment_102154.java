for (int face = 0; face < 6; face++) {

    float[] texCoords = {        // Texture coords for the above face (NEW)
        0.0f, (5.0f-face)/6.0f,  // A. left-bottom (NEW)
        1.0f, (5.0f-face)/6.0f,  // B. right-bottom (NEW)
        0.0f, (6.0f-face)/6.0f,  // C. left-top (NEW)
        1.0f, (6.0f-face)/6.0f   // D. right-top (NEW)
    };

    texBuffer.put(texCoords);
}