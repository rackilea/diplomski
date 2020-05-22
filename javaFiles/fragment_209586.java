@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        KeywordsCursorAdapter kwadapter = new KeywordsCursorAdapter(this, null);

        txtKeyword = (AutoCompleteTextView)this.findViewById(R.id.txtKeyword);
        txtKeyword.setAdapter(kwadapter);
        txtCity = (AutoCompleteTextView)this.findViewById(R.id.txtCity);
        btnSearch = (Button)this.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);
    }