boolean hasTranslated = false;
    if (!l2rArrow.isFired) {
        gl.glPushMatrix(); //save our state

            gl.glTranslatef(l2rArrow.GetToOriginX, l2rArrow.GetToOriginY, 0f); // translate to origin 0,0,0
            gl.glRotatef(LBow.getAngle(), 0f, 0f, 1f); //rotate
            gl.glTranslatef(-l2rArrow.GetToOriginX, -l2rArrow.GetToOriginY, 0f); // translate to where we want to draw it

            texture.bind(gl, Texture.TEXTURE_L2RARROW);
            mRect = new MeshRect(l2rArrow.getMyRect());
            mRect.Draw(GL10.GL_TRIANGLES, gl);

        gl.glPopMatrix(); //return to saved state

    } else {
        l2rArrow.Update(deltaTime);

        hasTranslated = true;
        gl.glPushMatrix();
        gl.glLoadIdentity();
            float camX = (float) ((l2rArrow.startX - l2rArrow.PosX));
            //Log.d("cam X =" + Float.toString(camX),"Y=");
            float camY = (float) ((l2rArrow.startY - l2rArrow.PosY));
            if (camY > 0) { camY = 0;}
            if (camX < -4800) { camX = -4800;}

            gl.glTranslatef(camX, camY,0f);

            texture.bind(gl, Texture.TEXTURE_L2RARROW);
            mRect = new MeshRect(l2rArrow.getMyRect());
            //Log.d("arrow X =" + Float.toString(l2rArrow.getMyRect().BottomLeftCorner.x),"Y=");
            mRect.Draw(GL10.GL_TRIANGLES, gl);


        if (l2rArrow.hasCollided) {
            //run collision code for detecting a hit and ending turn
        }
    }