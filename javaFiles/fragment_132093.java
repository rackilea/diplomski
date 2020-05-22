public TextView textView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    textView = (TextView) view.findViewById(R.id.textView1);
   }

public void onCashClick(View view) {
        money++;
        textView.setText(money + "$");
    }