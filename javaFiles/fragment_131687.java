GlideApp.with(context)
            .as(PictureDrawable.class)
            .transition(withCrossFade())
            .fitCenter()
            .listener(new SvgSoftwareLayerSetter())
            .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE))
            .load(uri).into(imageView);