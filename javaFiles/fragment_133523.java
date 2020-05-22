You can used a 3-d matrix(3): 


float[][] translationMatrix3 = {{1, 0, zamboniCenter.x},{0, 1, zamboniCenter.y},{0, 0, 1}};

float[][] zamboniCorner1Point3dNew = Matrix.cross(zamboniCorner1Point3dNew,translationMatrix3);
...
float[][] zamboniCorner4Point3dNew = Matrix.cross(zamboniCorner1Point3dNew,translationMatrix3);

Point' -> Point * Matrix3