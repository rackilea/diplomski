@Override
public void registerComponents(@NonNull Context context, @NonNull Glide glide, Registry registry) {
    registry.register(SVG.class, PictureDrawable.class, new SvgDrawableTranscoder())
            .prepend(SVG.class, new SvgEncoder())
            .append(InputStream.class, SVG.class, new SvgDecoder());
}