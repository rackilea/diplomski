kovil insertData;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);

                    textView = (TextView) findViewById(R.id.count);


                    insertData = new kovil("temple_name", "temple_type", "latitude",  "longitude", "image_name", "year_build", "address", 
                            "city", "email", "website", "telephone1", "telephone2",  "Description");


                        dbhand.open():
                        dbhand .Add_Temple(insertData );
                        dbhand.close():


                        kovil insertData2 = new kovil("temple_name", "temple_type", "latitude",  "longitude", "image_name", "year_build", "address", 
                                "city", "email", "website", "telephone1", "telephone2",  "Description");
                        dbhand.open():
                        dbhand .Add_Temple(insertData2 );
                        dbhand.close():

                        int count = dbhand .Get_Total_Temple();


                         textView.setText(Integer.toString(count));


                         // i want to display all the values in a list over here.

                        View_all_temples();


                }