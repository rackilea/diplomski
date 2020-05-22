enter code here


switch (event.getAction())
{
   case MotionEvent.ACTION_DOWN:
        mPath.reset();
    mPath.moveTo(x, y);
        mX = x;
        mY = y;
        startPoint = new PointF(event.getX(), event.getY());
        endPoint = new PointF();
        invalidate();

     //   isDrawing = true;
        break;
    case MotionEvent.ACTION_MOVE:
            float dx = Math.abs(x - mX);
        System.out.println("action move");
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)
        {
        //  currentDrawingPath.path.quadTo(mX,mY,(x + mX)/2, (y + mY)/2);
        }
        mX = x;
        mY = y;
          endPoint.x = event.getX();
            endPoint.y = event.getY();
          isDrawing = true;

          invalidate();
        break;
    case MotionEvent.ACTION_UP:
           mPath.lineTo(mX, mY);
float deltaX =   endPoint.x-startPoint.x;
           float deltaY =   endPoint.y-startPoint.y;
           float frac = (float) 0.1;

           float point_x_1 = startPoint.x + (float) ((1 - frac) * deltaX + frac * deltaY);
           float point_y_1 = startPoint.y + (float) ((1 - frac) * deltaY - frac * deltaX);

           float point_x_2 = endPoint.x;
           float point_y_2 = endPoint.y;

           float point_x_3 = startPoint.x + (float) ((1 - frac) * deltaX - frac * deltaY);
           float point_y_3 = startPoint.y + (float) ((1 - frac) * deltaY + frac * deltaX);



           mPath.moveTo(point_x_1, point_y_1);
           mPath.lineTo(point_x_2, point_y_2);
           mPath.lineTo(point_x_3, point_y_3);
           mPath.lineTo(point_x_1, point_y_1);
           mPath.lineTo(point_x_1, point_y_1);

            mCanvas.drawPath(mPath, ppaint);
            endPoint.x = event.getX();
            endPoint.y = event.getY();
            isDrawing = false;

            invalidate();
        break;
    default:
        break;
}