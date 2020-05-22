@Override
  protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.link);

     cb_leic= (CheckBox) findViewById(R.id.checkBox1);

     cb_leic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                boolean isChecked) {
            // TODO Auto-generated method stub
            if (isChecked) {
                Toast.makeText(Check.this, " cb_leic", Toast.LENGTH_SHORT)
                        .show();
                 cb_leic.setEnabled(false); // disable checkbox
            }

        }

    });
}