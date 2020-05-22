public class Person {
  public final String name;
  public final String sirname;
  public final String social_no;
  public final String creadit_card_no;

  public Person(String name, String sirname, String social_no,
      String creadit_card_no) {
    this.name = name;
    this.sirname = sirname;
    this.social_no = social_no;
    this.creadit_card_no = creadit_card_no;
  }

  @Override
  public String toString() {
    return String.format(
        "Person [name=%s, sirname=%s, social_no=%s, creadit_card_no=%s]", name,
        sirname, social_no, creadit_card_no);
  }
}