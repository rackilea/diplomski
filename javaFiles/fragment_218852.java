Decal decal1 = Decal.newDecal(1, 1, textures[1], true);
    decal1.setPosition(1.5f, 0, .5f);
    decals.add(decal1);
    Decal decal2 = Decal.newDecal(1, 1, textures[0], true);
    decal2.setPosition(1f, 0, .5f);
    decals.add(decal2);
    decal2.translate(0, 0, 1f);
//...
for (int i = 0; i < positions.length; i++) {
        positions[i] = new Vector3(decal1.getPosition());
        new Vector3(decal2.getPosition());
    }
    positions[0].set(decal1.getPosition());
    positions[1].set(decal2.getPosition());
    renderer = new ImmediateModeRenderer10();
                Vector3 intersection = new Vector3();


//render method
    Ray pickRay = null;
    renderTowers();
    camera3d.update();
    if (Gdx.input.isTouched()) {
        pickRay = camera3d.getPickRay(Gdx.input.getX(), Gdx.input.getY(),
                TB_X, TB_Y, TB_WIDTH, TB_HEIGHT);
    }
    boolean intersected1 = false;
    boolean intersected2 = false;
    for (int i = 0; i < positions.length; i++) {
        if (pickRay != null
                && Intersector.intersectRaySphere(pickRay, positions[0],
                        .5f, intersection)) {

            gl.glColor4f(1, 0, 0, 1);
            intersected1 = true;

        } else {
            gl.glColor4f(1, 1, 1, 1);
        }
        gl.glPushMatrix();
        gl.glTranslatef(positions[i].x, positions[i].y, positions[i].z);
        gl.glPopMatrix();
    }
    for (int j = 0; j < positions.length; j++) {
        if (pickRay != null
                && Intersector.intersectRaySphere(pickRay, positions[1],
                        .5f, intersection)) {

            gl.glColor4f(1, 0, 0, 1);
            intersected2 = true;

        } else {
            gl.glColor4f(1, 1, 1, 1);
        }
        gl.glPushMatrix();
        gl.glTranslatef(positions[j].x, positions[j].y, positions[j].z);
        gl.glPopMatrix();
    }

    Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(),
            Gdx.graphics.getHeight());
    sbatch.begin();
    if (intersected1) {
        stage.addActor(FireImage);
        camera3d.project(intersection, TB_X, TB_Y, TB_WIDTH, TB_HEIGHT);

    }
    if (intersected2) {
        stage.addActor(IceImage);
        camera3d.project(intersection, TB_X, TB_Y, TB_WIDTH, TB_HEIGHT);

    }