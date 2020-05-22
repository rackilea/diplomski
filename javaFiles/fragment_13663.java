@Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

             w = widthMeasureSpec - MeasureSpec.EXACTLY;
             h = heightMeasureSpec - MeasureSpec.EXACTLY;

            Log.d("Dim", Integer.toString(w) + " | " + Integer.toString(h));
        }