Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.mark_active_grey).copy(Bitmap.Config.ARGB_8888, true);

    Canvas canvas = new Canvas(bitmap);
    canvas.drawText(offersCount,
            canvas.getWidth()/2,
            canvas.getHeight()/2 - ((clustersPaint.getFontMetrics().ascent + clustersPaint.getFontMetrics().descent) / 2) ,
            clustersPaint);