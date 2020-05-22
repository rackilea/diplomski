public class Screen1 extends Activity
{
    private static final String EXTRA_MESSAGE = "extra_msg";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen1);

        final EditText t1 = (EditText)findViewById(R.id.a);
        final EditText t3 = (EditText)findViewById(R.id.c);
        final EditText t4 = (EditText)findViewById(R.id.d);

        Button bu1 = (Button)findViewById(R.id.bu);
        bu1.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View message)
                {
                    int f1,f3,f4; 
                    String e1 = t1.getText().toString();
                    String e3 = t3.getText().toString();
                    String e4 = t4.getText().toString();

                    if (e1.equals("") || e3.equals("") || e4.equals(""))
                    {
                        Toast.makeText(Screen1.this, "Please enter all numbers.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    try
                    {
                        f1 = Integer.parseInt(e1);
                        f4 = Integer.parseInt(e4);
                        f3 = Integer.parseInt(e3);

                        StringBuilder sb = new StringBuilder();
                        for (float i = 0.1f; i <= 5; i = i + .1f)
                        { 
                            sb.append(String.format("%.1f", i) + " mcg = " + (f1 * 60 * i * f4) / (f3 * 1000) + "\n");
                        }

                        Intent intent = new Intent(Screen1.this, Screen2.class);
                        intent.putExtra(EXTRA_MESSAGE, sb.toString());
                        startActivity(intent);
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(Screen1.this, "Invalid numbers.", Toast.LENGTH_SHORT).show();                            
                    }
                }       
            }
        );     
    }
}