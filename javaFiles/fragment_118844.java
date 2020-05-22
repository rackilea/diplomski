meshBuilder.begin();
meshBuilder.cylinder(4f, 6f, 4f, 16);
Mesh cylinder1 = meshBuilder.end();

meshBuilder.begin();
meshBuilder.cylinder(4f, 6f, 4f, 16);
Mesh cylinder2 = meshBuilder.end();


modelBuilder.begin();

modelBuilder.part("cylinder1", 
    cylinder1,
    Usage.Position | Usage.Normal | Usage.TextureCoordinates,
    new Material(
        TextureAttribute.createDiffuse(white), 
        ColorAttribute.createSpecular(1,1,1,1), 
        FloatAttribute.createShininess(8f)));

modelBuilder.part("cylinder2",
    cylinder2,
    Usage.Position | Usage.Normal | Usage.TextureCoordinates,
    new Material(
        TextureAttribute.createDiffuse(red), 
        ColorAttribute.createSpecular(1,1,1,1), 
        FloatAttribute.createShininess(8f)))
    .mesh.transform(new Matrix4().translate(0, 0, -2f));

Model finalCylinder = modelBuilder.end();