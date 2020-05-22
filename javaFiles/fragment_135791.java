public void update(float delta) {
    alpha += delta * speed;
    if (alpha <= 1f) {  
        float angle = fromAngle + alpha * (toAngle - fromAngle);

        Vector3 t = new Vector3(0.5f, -0.5f, 0);
        cubeInstance.transform.idt().translate(t).rotate(Vector3.Z, -angle).translate(t.scl(-1));
    } else {
        finished = true;
    }
}