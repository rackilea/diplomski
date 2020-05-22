int buttonValue = 0;

   //onClickListener method that returns an interface
   private View.OnClickListener createClickListener(final int value) {
    return new View.OnClickListener()  {

        @Override
        public void onClick(View view) {

            buttonValue = value;

            ToggleButton clickedButton = (ToggleButton) view;
            RadioGroup radioGroup= (RadioGroup) clickedButton.getParent();

            // **Change your TextView here
            ...

            // **Keep these since you still want to update all buttons
            for (int i = 0; i < radioGroup.getChildCount(); ++i) {
                View nextChild = radioGroup.getChildAt(i);
                if (!(nextChild instanceof ToggleButton)) {
                    continue;
                }
                if (nextChild.getId() != clickedButton.getId() || !clickedButton.isChecked()) {
                    ToggleButton tb2 = (ToggleButton) nextChild;
                    tb2.setChecked(false);
                }
            }
        }

    };
}



   @Override
        public Object instantiateItem(ViewGroup parent, final int position) {

            final int delPosition = position;
            //Get the inflater
            LayoutInflater inflater = (LayoutInflater)     parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate the root layout
            View view = inflater.inflate(R.layout.collection, null);

            // **Initialize your components earlier
            final int[] counter = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            final TextView num = (TextView) view.findViewById(R.id.num);
            num.setText(Integer.toString(counter[0]));

            // **Give your RadioGroup an id so that you can find it here
            ViewGroup group = view.findViewById(...);
            // **Loop through this group then for each child, set your listener
           for (...){
                      child=group.getChildAt(i);
                      child.setOnClickListener(createClickListener(i));
            }

            final ImageView plus_button = (ImageView) view.findViewById(R.id.plus_sign);
            final ImageView minus_button = (ImageView) view.findViewById(R.id.minus_sign);


              plus_button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view, final int value) {

                        if (plus_button.isPressed()) {

                            if ((counter[0] <= 9) && (counter[0] >= 0)) {

                                counter[0]++;
                                num.setText(Integer.toString(counter[0]));
                                buttonValue = Integer.parseInt(num.getText().toString());
                                // **Use the loop here again to update all buttons
                                for (int i = 0; i < group.getChildCount(); ++i) {
                                         View nextChild = group.getChildAt(i);
                                         ToggleButton tb2 = (ToggleButton) nextChild;
                                         if (i==buttonValue) {
                                         tb2.setChecked(true);
                                      } else {tb2.setChecked(false);}
                                }
                            }
                        }

                    }
                });

                minus_button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {

                        if (minus_button.isPressed()) {

                            if ((counter[0] <= 10) && (counter[0] > 0)) {
                                counter[0]--;
                                num.setText(Integer.toString(counter[0]));
                                buttonValue = Integer.parseInt(num.getText().toString());
                                // **Use the loop here again to update all buttons
                                for (int i = 0; i < group.getChildCount(); ++i) {
                                         View nextChild = group.getChildAt(i);
                                         ToggleButton tb2 = (ToggleButton) nextChild;
                                         if (i==buttonValue) {
                                         tb2.setChecked(true);
                                      } else {tb2.setChecked(false);}
                                }
                            }
                        }
                    }
                });

            parent.addView(view, 0);
            return view;
        }