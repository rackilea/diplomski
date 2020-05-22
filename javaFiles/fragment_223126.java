private ModelRenderable makeTriangleWithAnchors(@NonNull final List<AnchorNode> anchorNodes, @NonNull final Material material) {
    if (anchorNodes.size() != 3) throw new IllegalStateException("Different count of anchorsList than 3");

    final Vector3 p0 = anchorNodes.get(0).getLocalPosition();
    final Vector3 p1 = anchorNodes.get(1).getLocalPosition();
    final Vector3 p2 = anchorNodes.get(2).getLocalPosition();
    final Vector3 up = Vector3.up();
    final UvCoordinate uvTop = new UvCoordinate(0.5f, 1.0f);
    final UvCoordinate uvBotLeft = new UvCoordinate(0.0f, 0.0f);
    final UvCoordinate uvBotRight = new UvCoordinate(1.0f, 0.0f);
    final List<Vertex> vertices = new ArrayList<>(Arrays.asList(
            Vertex.builder().setPosition(p0).setNormal(up).setUvCoordinate(uvTop).build(),
            Vertex.builder().setPosition(p1).setNormal(up).setUvCoordinate(uvBotRight).build(),
            Vertex.builder().setPosition(p2).setNormal(up).setUvCoordinate(uvBotLeft).build()
    ));

    final List<Integer> triangleIndices = new ArrayList<>(3);
    triangleIndices.add(0);
    triangleIndices.add(2);
    triangleIndices.add(1);
    triangleIndices.add(0);
    triangleIndices.add(1);
    triangleIndices.add(2);

    final RenderableDefinition.Submesh submesh = RenderableDefinition.Submesh.builder()
            .setTriangleIndices(triangleIndices)
            .setMaterial(material)
            .build();
    final RenderableDefinition renderableDefinition = RenderableDefinition.builder()
            .setVertices(vertices)
            .setSubmeshes(Arrays.asList(submesh))
            .build();
    final CompletableFuture future = ModelRenderable.builder()
            .setSource(renderableDefinition)
            .build();

    final ModelRenderable result;
    try {
        result = (ModelRenderable) future.get();
    } catch (InterruptedException | ExecutionException e) {
        throw new AssertionError("Error creating renderable.", e);
    }

    if (result == null) {
        throw new AssertionError("Error creating renderable.");
    } else {
        return result;
    }
}