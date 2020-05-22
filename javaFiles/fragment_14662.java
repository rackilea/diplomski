private GridAdapter gridAdapter;
private String[] numbers;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    numbers = new String[25];
    gridAdapter = new GridAdapter(this, numbers);
}