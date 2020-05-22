static final int LIGHT_COUNT = 4;
final float[] tmpLightPositions = new float[3 * LIGHT_COUNT];
final float[] tmpLightColors = new float[4 * LIGHT_COUNT];

//...

int i = 0;
for (Vector3 pos : myLightPositions) {// should be LIGHT_COUNT of them
    tmpLightPositions[i++] = pos.x;
    tmpLightPositions[i++] = pos.y;
    tmpLightPositions[i++] = pos.z;
}
i = 0;
for (Color col : myLightColors) {
    tmpLightColors[i++] = color.r;
    tmpLightColors[i++] = color.g;
    tmpLightColors[i++] = color.b;
    tmpLightColors[i++] = color.a;
}
shader.setUniform3fv("lightPos", tmpLightPositions, 0, tmpLightPositions.length);
shader.setUniform4fv("lightColor", tmpLightColors, 0, tmpLightColors.length);