Picasso.with(context).load(uri).transform(new Transformation() {
        @Override
        public Bitmap transform(Bitmap source) {
            ///Do what you want with bitmap
            return source;
        }

        @Override
        public String key() {
            return null;
        }
    }).into(imageView);