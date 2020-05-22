public class MainActivity implements ColorPickerDialog.OnColorChangedListener
  {
       private Paint mPaint;  

        mPaint = new Paint();
       // on button click
        new ColorPickerDialog(this, this, mPaint.getColor()).show();

  }