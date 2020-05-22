paint.setStyle(Paint.Style.STROKE); //you can remove this now    
      for (int i = 0; i < 4; i++) {
                    paint.setStyle(Paint.Style.STROKE);//add this
                    int left = i * (rectWidth + space);
                    int right = left + rectWidth;           
                    Rect rect = new Rect(left, 0, right, topRectHeight);
                    canvas.drawRect(rect, paint);

                    if (i == 1){
                        paint.setStyle(Paint.Style.FILL); // change to this
                    }
                    Rect rect2 = new Rect(left, h - bottomRectHeight, right, h);
                    canvas.drawRect(rect2, paint);
                }