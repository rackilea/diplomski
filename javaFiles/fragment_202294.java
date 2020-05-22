public class CustomView extends RelativeLayout implements View.OnClickListener{

public TextView ClassName, Room, StartingTime, EndingTime;
public float Size;
public RelativeLayout mContainer;

// constructor
public CustomView (Context context, String subject, String room, String startingTime, String endingTime, int background, double size) {
    super(context);
    init(context);
    ClassName.setText(subject );
    Room.setText(room );
    StartingTime.setText(startingTime);
    EndingTime.setText(endingTime);
    mContainer.setBackgroundColor(background);
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)size);
    params.setMargins(3,0,3,0);
    mContainer.setLayoutParams(params2); 
}


private void init(Context context) {
    LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    mInflater.inflate(R.layout.my_view, this, true);

    this.mContainer = (RelativeLayout)findViewById(R.id.ClassContainer);
    this.ClassName = (TextView)findViewById(R.id.theClassName);
    this.Room = (TextView)findViewById(R.id.theClassRoom);
    this.StartingTime = (TextView)findViewById(R.id.theClassStartingTime);
    this.EndingTime = (TextView)findViewById(R.id.theClassEndingTime);
}