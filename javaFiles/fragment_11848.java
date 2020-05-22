private static class MyGraphicView extends View {
        DrawingData currentShape = null;
        ArrayList<DrawingData> drawingData = new ArrayList<>();

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    currentShape = new DrawingData(curShape);
                    currentShape.startX = (int) event.getX();
                    currentShape.startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    currentShape.stopX = (int) event.getX();
                    currentShape.stopY = (int) event.getY();
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    currentShape.stopX = (int) event.getX();
                    currentShape.stopY = (int) event.getY();

                    drawingData.add(currentShape);
                    currentShape = null;
                    this.invalidate();
                    break;
            }
            return true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(color);

            for (DrawingData drawingDatum : drawingData) {
                drawShape(drawingDatum, canvas, paint);
            }

            if (currentShape != null) {
                drawShape(currentShape, canvas, paint);
            }

        }

        private void drawShape(DrawingData drawingDatum, Canvas canvas, Paint paint) {
            switch (drawingDatum.shape) {
                case LINE:

                    canvas.drawLine(drawingDatum.startX, drawingDatum.startY, drawingDatum.stopX, drawingDatum.stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(drawingDatum.stopX - drawingDatum.startX, 2) + Math.pow(drawingDatum.stopY - drawingDatum.startY, 2));
                    canvas.drawCircle(drawingDatum.startX, drawingDatum.startY, radius, paint);
                    break;
                case RECTANGLE:
                    Rect rect = new Rect(drawingDatum.startX, drawingDatum.startY, drawingDatum.stopX, drawingDatum.stopY);
                    canvas.drawRect(rect, paint);
                    break;
            }
        }

        private static class DrawingData {

            int shape;
            int startX;
            int startY;
            int stopX;
            int stopY;

            public DrawingData(int shape) {
                this.shape = shape;
            }

        }

    }