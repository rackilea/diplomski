glMatrixMode(GL_MODELVIEW);
/*
If you wouldn't generate a new identity matrix every frame, you would **add** the rotation/translation to the previous one, which obviously isn't what you want
*/
glLoadIdentity();
Vector3f cameraPosititon = new Vector3f(10, 0, 5);    

/*
rotate selected matrix about 45 degrees around y
With the 1 as third argument you select that you want to rotate over the y-axis.
If you would pass 1 as 2nd or 4th argument, you would rotate over the x or the z axis.*/
glRotatef(45, 0, 1, 0);
//translate selected matrix about x, y, z
glTranslatef(-1 * cameraPosition.x, -1 * cameraPosition.y, -1 * cameraPosition.z);