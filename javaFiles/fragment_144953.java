// Before onCreate
private Button b, b2;

@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    b = (Button) findViewById(R.id.button);
    b2 = (Button) findViewById(R.id.button2);

    b.setOnClickListener(new OnClickListener() 
    {
            public void onClick(View v) 
            {
                b2.setEnabled(false);
            }
    });
{