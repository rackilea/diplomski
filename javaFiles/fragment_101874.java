public void onCreate(Bundle savedInstanceState)
{
    contactDBAdapter = new ContactDBAdapter(this);
    contactDBAdapter.open();

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    ....
}