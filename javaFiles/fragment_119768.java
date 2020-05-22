LinearLayout layout=(LinearLayout)view.findViewById(R.id.linearLayout);
LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                        android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);

                EditText edttext= new EditText(this);
                edttext.setId("edittext");
                edttext.setLayoutParams(params);

            layout.addView(edttext);