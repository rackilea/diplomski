//this moves the scaled 
glTranslatef(destCenter.x, destCenter.y, 0.0);
//scale to the desired factor
glScalef(scaleX, scaleY, 0.0);
//move the center of the scaling operation into the origin
glTranslatef(sourceCenter.x * -1.0, sourceCenter.y * -1.0, 0.0);