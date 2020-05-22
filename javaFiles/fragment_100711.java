private void setIndicator(DrawingMode drawingMode, int drawWidth) {
        if (drawingMode == DrawingMode.ERASER){
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(drawWidth, drawWidth);
            indicatorView.setLayoutParams(params);
            GradientDrawable border = new GradientDrawable();
            border.setStroke(1, 0xFF000000); //black border with full opacity
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                indicatorView.setBackgroundDrawable(border);
            } else {
                indicatorView.setBackground(border);
            }
            indicatorView.setVisibility(View.VISIBLE);
            isIndicatorVisible = true;
        }
    }