double max = 10.0; // number of songs in the view.
double min = 1.0;

int numb1;

b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                numb1 = (int)(Math.random() * (max - min) + min);
                e1.setText(String.valueOf(numb1));
                nyc2(numb1);
                b.setVisibility(View.GONE);
            }
        }
    });