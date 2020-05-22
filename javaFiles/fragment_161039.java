public class DataPojo {
    String fName;
    String cName;
    String[] cText;

    public dataPOJO() {}

    /* all the other stuff */
}

public class Phone_Save extends ActionBarActivity {
    private DataPojo dataPojo;
    // other members

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataPojo = new DataPojo();

        Intent intent = getIntent();
        dataPojo.setName(intent.getStringExtra("confirmed_name"));
        dataPojo.setRemainder(intent.getStringExtra("confirmed_text"));

        // other stuff...
    }
}