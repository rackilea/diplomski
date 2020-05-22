public static void main(String[] args) {
  double value = 2.55;
  String formule = "x+x";
  formule = formule.replace("x",
      String.valueOf(value));
  System.out.println(formule);
}