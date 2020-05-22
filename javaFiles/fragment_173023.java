fotoApparat.takePicture().
                toPendingResult().
                whenAvailable(bitmapPhoto -> {
        ImageView imageView = (ImageView) findViewById(R.id.result);
        return Unit.INSTANCE;
});