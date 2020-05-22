if (currVertexShader != 0) {
    glAttachShader(dummyProgram, currVertexShader);
    glDetachShader(currProgram, currVertexShader);
}
...
if (currVertexShader != 0) {
    glAttachShader(currProgram, currVertexShader);
    glDetachShader(dummyProgram, currVertexShader);
}