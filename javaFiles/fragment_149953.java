textView.setOnClickListener(new View.OnClickListener() {
                public int counter;

                @Override
                public void onClick(View v) {
                    counter += 1;
                    if (counter % 2 == 0) {
                        imageView.setImageResource(R.drawable.ic_one);
                        textView.setText("Text 1");
                    } else {
                        imageView.setImageResource(R.drawable.ic_two);
                        textView.setText("Text 2");
                    }
                }
            });