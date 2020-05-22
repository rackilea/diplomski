TriangleMesh mesh = stlImporter.getImport();
stlImporter.close();
MeshView mesh=new MeshView(cylinderHeadMesh);
Group root = new Group(mesh);
Scene scene = new Scene(root, 1024, 800, true);
Camera camera = new PerspectiveCamera();
scene.setCamera(camera);
primaryStage.setScene(scene);
primaryStage.show();