class Stomach {
  val content: Double = ...
  def eat(food: Food) = ...
}
class Horse {
  val stomach: Stomach
  def eat(food: Food) = stomach.eat(food)
}