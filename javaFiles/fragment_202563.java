private TextView[] textViews;

private TextView tvCurrentEditing;
private Button btnNext;
private Button btnPrev;
private Button btnSetText;
private int index = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    textViews = new TextView[3];

    //Initialize all your textviews like textViews[0] = findViewById(<textview-id1>);
    //textViews[1] = findViewById(<textview-id2>);
    //textViews[2] = findViewById(<textview-id3>);

    tvCurrentEditing = textViews[index];// I am assuming this is your first 

    //initialzie btnSettext
    btnSettext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvCurrentEditing.setText("<what ever you want");
        }
    });

    //initialize next buton
    btnNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(index < textViews.length) {
                index++;
            }
            tvCurrentEditing = textViews[index];
        }
    });

    //Initialize previous button
    btnPrev.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(index > 0) {
                index--;
            }
            tvCurrentEditing = textViews[index];
        }
    });

}