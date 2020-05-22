RoundRectShape rss = new RoundRectShape(new float[] { 12f, 12f, 12f,
            12f, 12f, 12f, 12f, 12f }, null, null);
    ShapeDrawable sds = new ShapeDrawable(rss);
    sds.setShaderFactory(new ShapeDrawable.ShaderFactory() {

        @Override
        public Shader resize(int width, int height) {
            LinearGradient lg = new LinearGradient(0, 0, 0, height,
                    new int[] { Color.parseColor("#e5e5e5"),
                            Color.parseColor("#e5e5e5"),
                            Color.parseColor("#e5e5e5"),
                            Color.parseColor("#e5e5e5") }, new float[] { 0,
                            0.50f, 0.50f, 1 }, Shader.TileMode.REPEAT);
            return lg;
        }
    });

    LayerDrawable ld = new LayerDrawable(new Drawable[] { sds, sd });
    ld.setLayerInset(0, 5, 5, 0, 0); // inset the shadow so it doesn't start right at the left/top
    ld.setLayerInset(1, 0, 0, 5, 5); // inset the top drawable so we can leave a bit of space for the shadow to use

    b.setBackgroundDrawable(ld);