protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main2);
int rows = getIntent().getIntExtra("rows",3);
int cols = getIntent().getIntExtra("cols",3);
matrix = (LinearLayout) findViewById(R.id.matrix);
matrix.removeAllViews();

//List<EditText> allEds = new ArrayList<EditText>();//thisline
//Now you have 2D array of 
EditText editTextMatrix[][] = new EditText[rows][cols];


//for (int a = 1; a <= rows; a++)
for (int a = 0; a < rows; a++)
{
    LinearLayout layout = new LinearLayout(Main2Activity.this);
    layout.setOrientation(LinearLayout.HORIZONTAL);
    layout.setLayoutParams(new LinearLayout.LayoutParams
            (LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,1));


    //for (int b = 1; b <= cols; b++)        
    for (int b = 0; b < cols; b++)
    {
        EditText text = new EditText(Main2Activity.this);
        //text.setBackgroundColor(Color.GRAY);
        // allEds.add(text);//thisline

       editTextMatrix[a][b] = text;

        text.setHint("**");
        text.setKeyListener(new DigitsKeyListener());

        text.setHintTextColor(Color.BLACK);

        //Setting ID to editText is not compulsory as you are saving a reference in editTextMatrix[][]  
        //int iD = 1;
        //noinspection ResourceType
        //text.setId(iD);

        text.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        //text.setText((j + 1) + " ");
        text.setTextColor(Color.RED);
        layout.addView(text);
    }
    matrix.addView(layout);
}


//Now you have 2D array of editTextMatrix   
//Iterate editTextMatrix to get the values;