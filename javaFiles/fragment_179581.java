private void attachCone(float size) {
        Cone cone = new Cone(size, size* 2);

        // The group for rotation
        arrowheadRotationGroup = new TransformGroup();
        arrowheadRotationGroup.
             setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        arrowheadRotationGroup.addChild(cone);

        // The group for positioning the cone
        arrowheadPositionGroup = new TransformGroup();
        arrowheadPositionGroup. 
              setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        arrowheadPositionGroup.addChild(arrowheadRotationGroup);

        super.addChild(arrowheadPositionGroup);
    }