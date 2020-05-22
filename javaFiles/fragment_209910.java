TextView mathExpressionTV;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.yourActivity);

    mathExpressionTV = (TextView) findViewById(R.id.mathexpressiontextview);

    ...
}