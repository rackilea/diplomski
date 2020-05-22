public class MainActivity extends Activity 
{
    double costPerTicket=18.00;
    int numberOfTickets;
    double totalCost;
    String groupChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tickets=(EditText)findViewById(R.id.txtTickets);
        final Spinner group=(Spinner)findViewById(R.id.txtGroup);
        Button cost = (Button)findViewById(R.id.btnCost);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,  R.array.LocationArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mySpinner = (Spinner)findViewById(R.id.YOUR_SPINNER_ID);
        mySpinner.setAdapter(adapter);
        cost.setOnClickListener(new OnClickListener()
        {
            final TextView result=((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v)
            {
                String SpinnerValue = mySpinner.getSelectedItem().toString();
                if(SpinnerValue.equals("Cape Marie")){
                // TODO Auto-generated method stub
                   numberOfTickets=Integer.parseInt(tickets.getText().toString());
                   totalCost = 20 * numberOfTickets;
                   DecimalFormat currency=new DecimalFormat("$###,###.##");
                   groupChoice=group.getSelectedItem().toString();
                   result.setText("Total cost for "+groupChoice +" is " +currency.format(totalCost)); 
            }
             if(SpinnerValue.equals("Star Island")){
                // TODO Auto-generated method stub
                   numberOfTickets=Integer.parseInt(tickets.getText().toString());
                   totalCost = 30 * numberOfTickets;
                   DecimalFormat currency=new DecimalFormat("$###,###.##");
                   groupChoice=group.getSelectedItem().toString();
                   result.setText("Total cost for "+groupChoice +" is " +currency.format(totalCost)); 
            }

        });
    }