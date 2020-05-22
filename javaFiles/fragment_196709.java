GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
Canvas3D canvas3d = new Canvas3D(config);

ViewingPlatform viewingPlatform = new ViewingPlatform();
viewingPlatform.setCapability(ViewingPlatform.ALLOW_BOUNDS_WRITE);
viewingPlatform.setBounds(bounds);
Viewer viewer = new Viewer(canvas3d);    

SimpleUniverse universe = new SimpleUniverse(viewingPlatform, viewer);