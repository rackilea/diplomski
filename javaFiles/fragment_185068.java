//...

View rootView = inflater.inflate(R.layout.fragment_main, container, false);
Button add = (Button)rootView.findViewById(R.id.R.id.bAdd);
add.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            counter++;
            display.setText("Your total is " + counter);
        }
    });