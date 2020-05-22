public class Drawing_Main extends ActionBarActivity {

...

Drawing_View drawingView;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_emoji_creation);
    drawingView = (Drawing_View)findViewById(R.id.drawing_view);
    green_light = (Button)findViewById(R.id.button1);
    ...