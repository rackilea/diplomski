EditText depth = (EditText) findViewById(R.id.depth);
TextView cost = (TextView) findViewById(R.id.cost);
Button btCalc = (Button) findViewById(R.id.bt_calc);
int costValue;

btCalc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //in here you can

            //get the depth from the EditText:
            int depthValue = Integer.valueOf(depth.getText().toString());

            //do the operations (example):
            costValue = depthValue + 1;

            //and display the cost in the TextView:
            cost.setText(String.valueOf(costValue));
        }
});