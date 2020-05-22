public class ButtonExampleActivity implements View.OnClickListener {

    private int[][] buttonViewIds = new int[][] {
            { R.id.button00, R.id.button01, R.id.button02 },
            { R.id.button10, R.id.button11, R.id.button12 },
            { R.id.button20...
    };
    // assuming each row is the same length you can do this
    private Button[][] buttonArray = new Button[buttonViewIds.length][buttonViewIds[0].length];

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.layout);

        for (int i=0; i<buttonViewIds.length; i++) {
            for (int j=0; j<buttonViewIds[0].length; j++) {
                buttonArray[i][j] = (Button) findViewById(buttonViewIds[i][j]);
                buttonArray[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button01:
            case R.id.button02:
            case R.id.button03:
                // do something
                break;
            case R.id.button10:
                // do something else
                break;
            ...
            default:
                Log.e("Not a handled Button: " 
                    + getResources().getResourceName(v.getId());
        }
    }
}