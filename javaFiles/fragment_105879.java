zoomIn.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            float scale = image.getCurrentZoom();
            PointF centerPoint = image.getCenterOfZoomedImage();
            image.setZoom(scale * 1.25, centerPoint.x, centerPoint.y);
        }
});