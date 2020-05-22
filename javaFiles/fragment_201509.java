int count = 0;
//display results
while (results.next()) {
  String data = results.getString("first_name");
  //name.setText(data);
  System.out.println(data);
  count++;
}
if (count < 1) {
  // Didn't even read one row
}