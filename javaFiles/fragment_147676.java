private static final int[] num2DrawableMap = new int[] {
    R.drawable.letterA,
    R.drawable.letterB,
    // etc
};

private static final int[] num2LayoutMap = new int[] {
    R.layout.layoutA,
    R.layout.layoutB,
    // etc
};

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    int[] _26Num = new int[6];
    int i, number;

    Random r1 = new Random(); // Random generator
    for (i = 1; i < _26Num.length; i++) { // Pick 6 Random Numbers
        do {
            // don't you like r1.nextInt(26) ?
            number = (int) (r1.nextDouble() * 26);
            // always 1? why in that loop?
            _26Num[1] = 1;
        } while (!(number != 0 && number != _26Num[1]
                && number != _26Num[2] && number != _26Num[3]
                && number != _26Num[4] && number != _26Num[5]));
        _26Num[i] = number;
    }

    // set the random content view
    int random = r1.nextInt(num2LayoutMap.size);
    setContentView(num2LayoutMap[random]);

    // find the buttons
    View[] buts = new View[5];
    buts[0] = findViewById(R.id.let1);
    buts[1] = findViewById(R.id.let2);
    buts[2] = findViewById(R.id.let3);
    buts[3] = findViewById(R.id.let4);
    buts[4] = findViewById(R.id.let5);

    for (View but : buts) {
        but.setOnClickListener(this);
        int drawableId = num2DrawableMap[_26Num[i]];
        but.setBackgroundResource(drawableId);
    }
}