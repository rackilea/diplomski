paint.setStyle(Paint.Style.STROKE); //add this     
      for (int i = 0; i < 4; i++) {
                    int left = i * (rectWidth + space);
                    int right = left + rectWidth;

                    if (i == 1){
                        paint.setStyle(Paint.Style.FILL); // change to this
                    }

                    Rect rect = new Rect(left, 0, right, topRectHeight);
                    canvas.drawRect(rect, paint);
                    paint.setStyle(Paint.Style.STROKE);//add this
                    Rect rect2 = new Rect(left, h - bottomRectHeight, right, h);
                    canvas.drawRect(rect2, paint);
                }