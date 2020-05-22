ImageView imageView = (ImageView) findViewById(R.id.image_view);
        float startX = imageView.getX();
        float startY = imageView.getY();
        float endX = startX + imageView.getWidth();
        float endY = startY + imageView.getHeight();
        Point point = new Point(10, 10);                       //test point
        if ((point.x >= startX && point.x <= endX)
                && (point.y >= startY && point.y <= endY) ){
            Log.e("MainActivity", "onCreate: " + "is part of object");
        } else {
            Log.e("MainActivity", "onCreate: " + "is not part of object");
        }