paint.setColor(color);                    // set the color
paint.setStrokeWidth(size);               // set the size
paint.setDither(true);                    // set the dither to true
paint.setStyle(Paint.Style.STROKE);       // set to STOKE
paint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
paint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
paint.setPathEffect(new CornerPathEffect(10) );   // set the path effect when they join.
paint.setAntiAlias(true);                         // set anti alias so it smooths