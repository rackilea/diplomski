final Anchor anchor = hitResult.createAnchor();
final AnchorNode anchorNode = new AnchorNode(anchor);

anchorNode.setParent(arFragment.getArSceneView().getScene());
anchorsList.add(anchorNode);

if (anchorsList.size() == 3) {
    final Texture.Sampler sampler = Texture.Sampler.builder()
            .setMinFilter(Texture.Sampler.MinFilter.LINEAR_MIPMAP_LINEAR)
            .setMagFilter(Texture.Sampler.MagFilter.LINEAR)
            .setWrapModeR(Texture.Sampler.WrapMode.REPEAT)
            .setWrapModeS(Texture.Sampler.WrapMode.REPEAT)
            .setWrapModeT(Texture.Sampler.WrapMode.REPEAT)
            .build();

    Texture.builder()
            .setSource(() -> getAssets().open("wall.jpg"))
            .setSampler(sampler)
            .build()
            .thenAccept(texture -> MaterialFactory.makeOpaqueWithTexture(this, texture)
                    .thenAccept(material -> {
                        final Node node = new Node();
                        final ModelRenderable triangle = makeTriangleWithAnchors(anchorsList, material);

                        node.setParent(arFragment.getArSceneView().getScene());
                        node.setRenderable(triangle);
                    })
            );
}