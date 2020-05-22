@Override
public void onCreate(Bundle savedInstanceState) 
{

    super.onCreate(savedInstanceState);
    setContentView(R.layout.list);
    //////////////////////////////////////////////////////Solution
    errorText = (TextView)findViewById(R.id.yourTextView);

    Bundle extras = getIntent().getExtras();
    if(extras!=null){
        petrolPriceURL =extras.getString("URLString");

    }
    // Get the TextView object on which to display the results
    response = (TextView)findViewById(R.id.title);
    try
    {
        // Get the data from the RSS stream as a string
        result =  petrolPriceString(petrolPriceURL);

        // Do some processing of the data to get the individual parts of the RSS stream
        // At some point put this processing into a separate thread of execution
        // Display the string in the TextView object just to demonstrate this capability
        // This will need to be removed at some point
        response.setText(result);
    }
    catch(IOException ae)
    {
        // Handle error
        response.setText("Error");
        // Add error info to log for diagnostics
        errorText.setText(ae.toString()); //////////This variable is not intialized.
    }