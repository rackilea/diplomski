rule "First Rule"
  salience 90
  when
    String(ifContains(this, "et"))
  then
    System.out.println("Does contain");
end