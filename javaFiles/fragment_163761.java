CategoryItemRenderer renderer = new StackedBarRenderer {
     private Paint[] colors = new Paint[] {
        new Color(255, 0, 0), 
        new Color(0, 0, 255)
     }

     public Paint getSeriesPaint(int series) {
       return colors[(series % 2)];
     }
};