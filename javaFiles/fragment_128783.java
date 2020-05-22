//Creating rotation matrix
Matrix.setRotateM(rotationMatrix, 0, angle, 0f, 0f, -1f);

//rotation x camera = modelView    
Matrix.multiplyMM(modelViewProjectionMatrix, 0, modelViewProjectionMatrix, 0, rotationMatrix, 0);

Matrix.setRotateM(rotationMatrix, 0, angle, 0f, -1f, 0f);
Matrix.multiplyMM(modelViewProjectionMatrix, 0, modelViewProjectionMatrix, 0, rotationMatrix, 0);

Matrix.setRotateM(rotationMatrix, 0, angle, -1f, 0f, 0f);
Matrix.multiplyMM(modelViewProjectionMatrix, 0, modelViewProjectionMatrix, 0, rotationMatrix, 0);

cube.draw(modelViewProjectionMatrix);