float[][] matrix = Matrix.cross(Matrix.cross(translationMatrix1,rotationMatrix2),translationMatrix3);

float[][] zamboniCorner1Point3dNew = Matrix.cross(zamboniCorner1Point3d,matrix);
...
float[][] zamboniCorner4Point3dNew = Matrix.cross(zamboniCorner4Point3d,matrix);


Point' -> Point * (Matrix-1 * Matrix-2 * Matrix-3)