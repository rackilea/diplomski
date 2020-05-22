public class Ellipse extends Group {

    final Rotate rx = new Rotate(0, Rotate.X_AXIS);
    final Rotate ry = new Rotate(0, Rotate.Y_AXIS);
    final Rotate rz = new Rotate(0, Rotate.Z_AXIS);

    public Ellipse(double size, Color color, double shade) {
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(color);
        material.setSpecularColor(Color.BLACK);

        getTransforms().addAll(rz, ry, rx);
        Sphere s = new Sphere(size);
        s.setMaterial(material);
        getChildren().addAll(s);
    }
}