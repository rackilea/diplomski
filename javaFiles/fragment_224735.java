final BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    in.mark(in.available());
    BitmapFactory.decodeStream(in, null, options);
    (or)
    BitmapFactory.decodeFile(pathName);
    (or)
    BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.ic_launcher);
    String name = options.outMimeType;