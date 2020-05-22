public class MyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button changeColor = new Button(this);
        changeColor.setText("Color");
        changeColor.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        changeColor.setOnClickListener(new View.OnClickListener() {
            int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
            @Override
            public void onClick(View view) {
                final Random random = new Random();
                view.setBackgroundColor(colors[random.nextInt(colors.length - 1) + 1]);
            }
        });
        setContentView(changeColor);
    }