float mat[] = new float[16];

Transform t = new Transform();
t = body.getWorldTransform(t);
t.origin.get(mat);

        x = mat[0];
        y = mat[1];
        z = mat[2];

   gl.glRotatef(xrot, 1, 0, 0);  //rotate our camera on teh x-axis (left and right)
   gl.glRotatef(yrot, 0, 1, 0);  //rotate our camera on the y-axis (up and down)
   gl.glTranslatef(-x, -y, -z); //translate the screen to the position of our camera