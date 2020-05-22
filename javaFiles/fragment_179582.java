private final Vector3f yAxis = new Vector3f(0f, 1f, 0f);
private Vector3f direction; 

private void rotateCone() {
        // Get the normalized axis perpendicular to the direction 
        Vector3f axis = new Vector3f();
        axis.cross(yAxis, direction);
        axis.normalize();

        // When the intended direction is a point on the yAxis, rotate on x
        if (Float.isNaN(axis.x) && Float.isNaN(axis.y) && Float.isNaN(axis.z)) 
        {
            axis.x = 1f;
            axis.y = 0f;
            axis.z = 0f;
        }
        // Compute the quaternion transformations
        final float angleX = yAxis.angle(direction);
        final float a = axis.x * (float) Math.sin(angleX / 2f);
        final float b = axis.y * (float) Math.sin(angleX / 2f);
        final float c = axis.z * (float) Math.sin(angleX / 2f);
        final float d = (float) Math.cos(angleX / 2f);

        Transform3D t3d = new Transform3D();
        Quat4f quat = new Quat4f(a, b, c, d);
        t3d.set(quat);
        arrowheadRotationGroup.setTransform(t3d);

        Transform3D translateToTarget = new Transform3D();
        translateToTarget.setTranslation(this.direction);
        arrowheadPositionGroup.setTransform(translateToTarget);
    }