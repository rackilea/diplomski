@Override
public void start(Stage primaryStage) throws Exception {

    // 3D
    Sphere sphere = new Sphere(5);
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseMap(new Image(getClass().getResource("diffuse.jpg").toExternalForm()));
    sphere.setMaterial(phongMaterial);
    ...
}