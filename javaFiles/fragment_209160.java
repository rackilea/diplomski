vertices = new float[]{
    -2,  1, 0, // 0
    -2, -1, 0, // 1
     0,  1, 0, // 2
     0, -1, 0, // 3
     2,  1, 0, // 4
     2, -1, 0  // 5
};

texBuffer = setFloatBuffer(new float[]{
    0, 0,
    0, 1,
    1, 0,
    1, 1,
    2, 0,
    2, 1
});

orderBuffer = setShortBuffer(new short[]{
    0, 1, 2, 3, 4, 5
});