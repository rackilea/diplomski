View previousView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView previousText = (TextView) previousView;
            TextView curText = (TextView) v;
            // If the clicked view is selected, deselect it
            if (curText.isSelected()) {
                curText.setSelected(false);
                curText.setTextColor(Color.RED);
            } else { // If this isn't selected, deselect  the previous one (if any)
                if (previousText != null && previousText.isSelected()) {
                    previousText.setSelected(false);
                    previousText.setTextColor(Color.RED);
                }
                curText.setSelected(true);
                curText.setTextColor(Color.BLUE);
                previousView = v;
            }

        }
    };

    findViewById(R.id.txt).setOnClickListener(clickListener);
    findViewById(R.id.txt2).setOnClickListener(clickListener);
    findViewById(R.id.txt3).setOnClickListener(clickListener);

}