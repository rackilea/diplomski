List<Integer> data = new ArrayList<Integer>();
data.add(Integer.parseInt(TextView1.getText().toString()));
data.add(Integer.parseInt(TextView2.getText().toString())); 
data.add(Integer.parseInt(TextView3.getText().toString()));
Collections.sort(data);
TextView4.setText(data.toString());