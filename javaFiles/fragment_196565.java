public class Game extends Activity {

private gameView newGameView = null;
private MyPoint newMyPoint = null;

private java.util.List<MyPoint> pointsQ = new ArrayList<MyPoint>();

@Override
public void onCreate(Bundle savedInstanceState) {
    try {

        newGameView = new gameView(this);
        newGameView.setBackgroundColor(Color.WHITE);
        super.onCreate(savedInstanceState);
        setContentView(newGameView);
        //initially requestFocus
        newGameView.requestFocus();


    } catch (NullPointerException exc) {
        Log.d(this.getClass().getName().toString(), exc.getMessage());
    }
}

//inner class that represents View 
public class gameView extends View {


private Paint wPaint = new Paint(Color.BLACK);


public gameView(Context context) {
    super(context);
    setFocusable(true); 
    setFocusableInTouchMode(true); 
    //
    wPaint.setStyle(Paint.Style.FILL);
    wPaint.setStrokeWidth(3);

}

//implemented in order to handle touch events 
@Override
public boolean onTouchEvent(MotionEvent event) {
    int action = event.getAction();
    float currentX = event.getX();
    float currentY = event.getY();

    //log x and y coordinates
    Log.d(this.getClass().getName().toString(), "X=" + currentX);
    //log x and y coordinates
    Log.d(this.getClass().getName().toString(), "Y=" + currentY);

    if (action == MotionEvent.ACTION_DOWN) {

        // log action down 
        Log.d(this.getClass().getName().toString(), "MotionEvent = ACTION_DOWN");

        newMyPoint = new MyPoint(currentX, currentY);
        pointsQ.add(newMyPoint);


    } else if (action == MotionEvent.ACTION_MOVE) {

        //log action move 
        Log.d(this.getClass().getName().toString(), "MotionEvent = ACTION_MOVE");

        newMyPoint = new MyPoint(currentX, currentY);
        pointsQ.add(newMyPoint);

    } else if (action == MotionEvent.ACTION_UP) {

        //log action move 
        Log.d(this.getClass().getName().toString(), "MotionEvent = ACTION_UP");

        newMyPoint = new MyPoint(currentX, currentY);
        pointsQ.add(newMyPoint);


    }

    //I moved the invalidate to the end of the method se=ince all action called it anyways 
    this.invalidate(); 
    return true;
}//end onTouch() 

@Override
protected void onDraw(Canvas canvas) {
    MyPoint p = null;
    for (int i = 0; i < pointsQ.size(); i++) {
        //get MyPoint & draw based on its x,y attributes 
        p = (MyPoint) pointsQ.get(i);
               //
        canvas.drawCircle(p.getX(),p.getY(),2,wPaint);
        //
        Log.d(this.getClass().getName().toString(), "onDraw X= "+p.getX()+" Y= "+p.getY());    
        }

    } 
}//end inner class gameView
}//end Game activity class