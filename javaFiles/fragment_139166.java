linear = (LinearLayout) rootView.findViewById(R.id.linear);
    .
    .
    .   

     RelativeLayout.LayoutParams layoutParam = new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    LinearLayout layout = new LinearLayout(getActivity());
                    layout.setLayoutParams(layoutParam);
                    layout.setOrientation(LinearLayout.VERTICAL);

                    // Below will add three linear layout with 4 buttons in each
                    for (int i = 0; i < 3; i++) {
                        LinearLayout row = new LinearLayout(getActivity());
                        row.setLayoutParams(new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT));
//Here is important
                        row.setOrientation(LinearLayout.VERTICAL);

                        for (int j = 0; j < 4; j++) {
                            Button btnTag = new Button(getActivity());
                            btnTag.setLayoutParams(new LayoutParams(
                                    LayoutParams.WRAP_CONTENT,
                                    LayoutParams.WRAP_CONTENT));
                            btnTag.setText("Button " + (j + 1 + (i * 4)));
                            btnTag.setId(j + 1 + (i * 4));
                            row.addView(btnTag);
                        }
                        layout.addView(row);
                    }
                    linear.addView(layout);
                    // You can set also
                    // setContentView(layout)