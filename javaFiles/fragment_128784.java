//Creating rotation matrix
Matrix.setRotateM(rotationMatrix, 0, angle, 0f, 0f, -1f);

//rotation x camera = modelView
float[] duplicateMatrix = Arrays.copyOf(modelViewProjectionMatrix, 16);

Matrix.multiplyMM(modelViewProjectionMatrix, 0, duplicateMatrix, 0, rotationMatrix, 0);

Matrix.setRotateM(rotationMatrix, 0, angle, 0f, -1f, 0f);
duplicateMatrix = Arrays.copyOf(modelViewProjectionMatrix, 16);
Matrix.multiplyMM(modelViewProjectionMatrix, 0, duplicateMatrix, 0, rotationMatrix, 0);

Matrix.setRotateM(rotationMatrix, 0, angle, -1f, 0f, 0f);
duplicateMatrix = Arrays.copyOf(modelViewProjectionMatrix, 16);
Matrix.multiplyMM(modelViewProjectionMatrix, 0, duplicateMatrix, 0, rotationMatrix, 0);

cube.draw(modelViewProjectionMatrix);