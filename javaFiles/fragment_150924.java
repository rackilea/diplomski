ParameterBlock paramBlock = new ParameterBlock();
paramBlock.addSource(((RenderedOp) pi).createInstance()); // Updated this
paramBlock.add(0.5f); // x Scale (Change these two Scale values!)
paramBlock.add(0.5f); // y Scale
paramBlock.add(0.0f); // x Translate
paramBlock.add(0.0f); // y Translate
paramBlock.add(new InterpolationBilinear()); // I think this Interpolation should work...)
RenderedOp resized = JAI.create("scale", paramBlock, null);