public void addTapHandler(Node node) {
    node.setOnTapListener((HitTestResult hitTestResult, MotionEvent motionEvent) -> {
      // Hit test point will be where the ray from the screen point intersects the model.

      // Create a sphere and attach it to the point.
      Color color = new Color(.8f, 0, 0);

      // Note: you can make one material and one sphere and reuse them.
      MaterialFactory.makeOpaqueWithColor(this, color)
              .thenAccept(material -> {
                // The sphere is in local coordinate space, so make the center 0,0,0
                Renderable sphere = ShapeFactory.makeSphere(0.05f, Vector3.zero(),
                                                            material);

                Node indicatorModel = new Node();
                indicatorModel.setParent(hitTestResult.getNode());
                indicatorModel.setWorldPosition(hitTestResult.getPoint());
                indicatorModel.setRenderable(sphere);
              });
    });
  }