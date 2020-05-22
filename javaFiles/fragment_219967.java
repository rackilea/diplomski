public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game_layout);
    gridLayout = (GridLayout) findViewById(R.id.gl_puzzle);
    . . . 

    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    for (int i = 0; i < NUM_CELLS; i++) {
        RelativeLayout tmpCell = (RelativeLayout) inflater.inflate(R.layout.picture_cell, gridLayout, false);
        ImageView pic = tmpCell.findViewById(R.id.iv_cell_image);
        pic.setImageBitmap(pieces.get(i));
        tmpCell.setOnClickListener(this);
        gridLayout.addView(tmpCell);
    }