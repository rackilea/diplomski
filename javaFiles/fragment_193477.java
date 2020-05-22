private static RenderedImage horizontalMosaic(RenderedImage image1, RenderedImage image2) {
    ImageLayout imageLayout = new ImageLayout(0, 0, image1.getWidth() + image2.getWidth(), image1.getHeight());
    RenderingHints renderingHints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, imageLayout);
    RenderedImage image3 = MosaicDescriptor.create(new RenderedImage[]{image1}, MosaicDescriptor.MOSAIC_TYPE_OVERLAY, null, null, null, null, renderingHints);
    RenderedImage image4 = MosaicDescriptor.create(new RenderedImage[]{image2}, MosaicDescriptor.MOSAIC_TYPE_OVERLAY, null, null, null, null, renderingHints);
    RenderedImage image5 = TranslateDescriptor.create(image4, (float)image1.getWidth(), 0.0f, null, renderingHints);
    return MosaicDescriptor.create(new RenderedImage[]{image3, image5}, MosaicDescriptor.MOSAIC_TYPE_OVERLAY, null, null, null, null, renderingHints);
}

private static RenderedImage verticalMosaic(RenderedImage image1, RenderedImage image2) {
    ImageLayout imageLayout = new ImageLayout(0, 0, image1.getWidth(), image1.getHeight() + image2.getHeight());
    RenderingHints renderingHints = new RenderingHints(JAI.KEY_IMAGE_LAYOUT, imageLayout);
    RenderedImage image3 = MosaicDescriptor.create(new RenderedImage[]{image1}, MosaicDescriptor.MOSAIC_TYPE_OVERLAY, null, null, null, null, renderingHints);
    RenderedImage image4 = MosaicDescriptor.create(new RenderedImage[]{image2}, MosaicDescriptor.MOSAIC_TYPE_OVERLAY, null, null, null, null, renderingHints);
    RenderedImage image5 = TranslateDescriptor.create(image4, 0.0f, (float)image1.getHeight(), null, renderingHints);
    return MosaicDescriptor.create(new RenderedImage[]{image3, image5}, MosaicDescriptor.MOSAIC_TYPE_OVERLAY, null, null, null, null, renderingHints);
}