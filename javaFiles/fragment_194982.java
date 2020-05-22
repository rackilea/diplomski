public class WaveForm extends View {

    private double currentPoint = 50;
    public void setCurrentPoint(double currentPoint){
         this.currentPoint=currentPoint;
    }
    public double getCurrentPoint(){

       return this.currentPoint;
    }
    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawLine(x, 0, y, getCurrentPoint(), mLinePaint);   
        ...
    }

}