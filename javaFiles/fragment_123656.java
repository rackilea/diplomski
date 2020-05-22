rule "First Rule"
  salience 90
  when
    String(this contains "et")
  then
    System.out.println("Does contain");
end