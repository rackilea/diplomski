float[][] translationMatrix1 = {{1, 0,-zamboniCenter.x},{0, 1,-zamboniCenter.y},{0, 0, 1}};

float[][] zamboniCorner1Point3dNew = Matrix.cross(zamboniCorner1Point3d,translationMatrix1);
...
float[][] zamboniCorner4Point3dNew = Matrix.cross(zamboniCorner4Point3d,translationMatrix1);

Point' -> Point * Matrix1