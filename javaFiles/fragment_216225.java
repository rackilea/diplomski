calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list = list.getText().toString().trim();
                String carat = carat.getText().toString().trim();
                String discount = discount.getText().toString().trim();
                String converter = converter.getText().toString().trim();
                String discamt = discamt.getText().toString().trim();

                if(list.length() > 0 && carat.length() > 0 && discount.length() > 0
                        && converter.length() > 0 && discamt.length() > 0 )
                {
                     try {
                            int_list = Double.parseDouble(list.getText().toString());
                            int_carat = Double.parseDouble(carat.getText().toString());
                            int_discount = Double.parseDouble(discount.getText().toString());
                            int_converter = Double.parseDouble(converter.getText().toString());
                            int_discamt = Double.parseDouble(discamt.getText().toString());


                            int_discamt = (int_list * int_discount) / 100;
                            int_price = int_list - int_discamt;
                            int_pricers = int_price * int_converter;
                            int_total = int_price * int_converter * int_carat;


                            price.setText(Double.toString(int_price));
                            discamt.setText(Double.toString(int_discamt));
                            caratrs.setText(Double.toString(int_pricers));
                            total.setText(Double.toString(int_total));
                     }
                    catch(NumberFormatException e)
                    {
                        e.printStackTrace();
                    }
                }else
                {
                    Toast.makeText(context, "Please enter all value.", Toast.LENGTH_SHORT).show();
                }
            }
            });