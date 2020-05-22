class Flyer {
  Flyer(String name, String mealType) {
    this.name = name;
    this.mealType = mealType;
  }
  String name;
  String mealType;
  public String toString() {
    return "Name: " + name + ", Meal: " + mealType;
  }
}