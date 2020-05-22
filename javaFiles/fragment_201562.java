//protected float[] matrix = new float[16];//unused!

public void update(boolean updateFrustum) {

        float aspect = camera.viewportWidth / camera.viewportHeight;
        camera.projection.setToProjection(Math.abs(camera.near), Math.abs(camera.far), camera.fieldOfView, aspect);
        camera.view.setToLookAt(camera.position, tempVector.set(camera.position).add(camera.direction), camera.up);

        camera.view.rotate(q); // THIS IS THE ONLY REAL CHANGE TO YOUR CODE!

        camera.combined.set(camera.projection);
        Matrix4.mul(camera.combined.val, camera.view.val);

        if (updateFrustum) {
            camera.invProjectionView.set(camera.combined);
            Matrix4.inv(camera.invProjectionView.val);
            camera.frustum.update(camera.invProjectionView);
        }
    }