userinput = ...; //this part is fine
for (Product p : products) {
  if (userinput.equals(p.getProductId())) {
    System.out.println('there are ' + p.getAmmountToPick() + " left");
  }
}