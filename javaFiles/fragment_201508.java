if (!results.next()) {
  System.out.println("empty");
} else {
  //display results
  do {
    String data = results.getString("first_name");
    //name.setText(data);
    System.out.println(data);
  } while (results.next());
}