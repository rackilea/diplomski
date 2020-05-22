final displayInteger = (TextView) convertView.findViewById(R.id.integer_number);

increase.setOnClikcListener(new OnClickListener {   
    @Override
    public void onClick(View view)
    {
   int count = sia.get(position);
   count++;
   sia.put(position, count);
   displayInteger.setText("" + count);