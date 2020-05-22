You can used this 3-d matrix (2):

float[][] rotationMatrix2 = {Math.cos(rotationAngle), Math.sin(rotationAngle), 0 }, {-Math.sin(rotationAngle), Math.cos(rotationAngle), 0}, {0, 0, 1 }};


float[][] zamboniCorner1Point3dNew = Matrix.cross(zamboniCorner1Point3dNew,rotationMatrix2);
...
float[][] zamboniCorner4Point3dNew = Matrix.cross(zamboniCorner4Point3dNew,rotationMatrix2);

Point' -> Point * Matrix2