public Matrix4f set(float cameraX, float cameraY, float cameraZ, 
float lookX, float lookY, float lookZ){

//My advice to you: you shouldn't create new matrix everytime, 
//it will give you little glitches. 
//Create some new class containing this method, change type to void 
//and declare "matrix" as a field - make your own "camera" object (java object)

Matrix4f matrix = new Matrix4f();
Matrix4f aux = new Matrix4f();

Vector3f dir = new Vector3f(lookX - cameraX, lookY - cameraY, lookZ - cameraZ);
Vector3f up = new Vector3f(0, 1f, 0);
Vector3f right = new Vector3f();
dir.normalise();

Vector3f.cross(dir,up,right);
right.normalise();

Vector3f.cross(right,dir,up);
up.normalise();

matrix.m00 = right.getX();
matrix.m01 = right.getY();
matrix.m02 = right.getZ();
matrix.m03 = 0.0f;

matrix.m10 = up.getX();
matrix.m11 = up.getY();
matrix.m12 = up.getZ();
matrix.m13 = 0.0f;

matrix.m20 = -dir.getX();
matrix.m21 = -dir.getY();
matrix.m22 = -dir.getZ();
matrix.m23 =  0.0f;

matrix.m30 = 0.0f;
matrix.m31 = 0.0f;
matrix.m32 = 0.0f;
matrix.m33 = 1.0f;

//setup aux as a translation matrix by placing positions in the last column
aux.m30 = -cameraX;
aux.m31 = -cameraY;
aux.m32 = -cameraZ;

//multiplication(in fact translation) viewMatrix with aux
Matrix4f.mul(matrix, aux, matrix);

return matrix;
}